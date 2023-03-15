package tasklist

import kotlinx.datetime.*
import java.time.Year
import kotlin.system.exitProcess
import com.squareup.moshi.*
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.File

data class Task(
    var priority: String,
    var text: String,
    var dateTask: kotlinx.datetime.LocalDate,
    var timeTask: LocalDateTime) {
    var daysUntil: String = daysUntil()

    fun daysUntil(): String {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date

        val numberOfDays = currentDate.daysUntil(dateTask)
        return (when {
            numberOfDays == 0 -> "T"
            numberOfDays > 0 -> "I"
            else -> "O"
        })
    }

}



fun printTasks(tasks: MutableList<Task>) {

    if (tasks.isEmpty()) {
        println("No tasks have been input")
    } else {
        println("+----+------------+-------+---+---+--------------------------------------------+")
        println("| N  |    Date    | Time  | P | D |                   Task                     |")
        println("+----+------------+-------+---+---+--------------------------------------------+")
        var i = 0
        for (task in tasks) {
            i++
            println("| $i".padEnd(5) + getLineFromTask(task))
            println("+----+------------+-------+---+---+--------------------------------------------+")
        }
    }
}

fun getLineFromTask(tk : Task) : String{
  return "| ${tk.dateTask} | ${pfx0(tk.timeTask.hour)}:${pfx0(tk.timeTask.minute)} | ${priorityColor(tk.priority)} | ${daysUntilColor(tk.daysUntil())} |${textFormat(tk.text)}"
}


fun daysUntilColor(s: String): String {
    return (when (s) {
        "I" -> "\u001B[102m \u001B[0m"
        "T" -> "\u001B[103m \u001B[0m"
        "O" -> "\u001B[101m \u001B[0m"
        else -> ""
    })
}

fun cutText(s: String): String {
    return ("|    |            |       |   |   |" + (s).padEnd(44) + "|")
}

fun textFormat(s: String): String {
    var sresult: String = ""
    val stList = s.split("\n")

    for (lineSt in stList) {
        if (lineSt.length > 0 && lineSt.length <= 44) {
            sresult = textFormatLT44(sresult, lineSt)
        } else {
            sresult = textFormatGT44(sresult, lineSt)
        }
    }
    return sresult
}

private fun textFormatGT44(sresult: String, st: String): String {
    var sresult1 = sresult
    for (j in 0..(st.length / 44) - 1) {
        val stc: String = st.substring(j * 44, (j + 1) * 44)
        if (sresult1 == "" || sresult1 == null) {
            sresult1 = stc.padEnd(44) + "|"
        } else if (stc != null) {
            sresult1 = sresult1 + "\n" + cutText(stc)
        }
    }

    if (st.length % 44 > 0) {
        val stc: String = st.substring((st.length - st.length % 44), st.length)
        if (sresult1 == "" || sresult1 == null) {
            sresult1 = stc.padEnd(44) + "|"
        } else if (stc != null) {
            sresult1 = sresult1 + "\n" + cutText(stc)
        }
    }
    return sresult1
}

private fun textFormatLT44(sresult: String, st: String): String {
    var sresult1 = sresult
    if (sresult1 == "" || sresult1 == null) {
        sresult1 = st.padEnd(44) + "|"
    } else if (st != "" && st != null) {
        sresult1 = sresult1 + "\n" + cutText(st)
    }
    return sresult1
}

fun priorityColor(p: String): String {
    return (when (p) {
        "C" -> "\u001B[101m \u001B[0m"
        "H" -> "\u001B[103m \u001B[0m"
        "N" -> "\u001B[102m \u001B[0m"
        "L" -> "\u001B[104m \u001B[0m"
        else -> ""
    })
}


fun main() {
    var tasks : MutableList<Task> = readTaskListFromFile()

    do {
        println("Input an action (add, print, edit, delete, end):")

        var action = readln()
        when (action) {
            "add" -> addTask(tasks)
            "print" -> printTasks(tasks)
            "edit" -> editTask(tasks)
            "delete" -> deleteTask(tasks)
            "end" -> endTask(tasks)
            else -> messageInvalid()
        }
    } while (true)
}

fun readTaskListFromFile(): MutableList<Task> {
    val jsonFile = File("tasklist.json")

    if(jsonFile.exists()){
        val type = Types.newParameterizedType(List::class.java, Task::class.java)

        val moshi = Moshi.Builder()
            .add(TaskJsonAdapter())
            .add(KotlinJsonAdapterFactory())
            .build()

        val taskListAdapter = moshi.adapter<List<Task>>(type)

        val taskList = taskListAdapter.fromJson( jsonFile.readText())

        if (taskList != null && !taskList.isEmpty()){
            return taskList.toMutableList()
        } else {
            return mutableListOf<Task>()
        }
    } else {
        return mutableListOf<Task>()
    }

}


fun readFieldToEdit(task: Task): Task {
    var fieldToEdit: String
    println("Input a field to edit (priority, date, time, task):")
    fieldToEdit = readln()
    when (fieldToEdit.uppercase()) {
        "PRIORITY" -> task.priority = readTaskPriority()
        "DATE" -> task.dateTask = readTaskDate()
        "TIME" -> task.timeTask = readTaskTime()
        "TASK" -> task.text = readTaskText()
        else -> {
            println("Invalid field")
            readFieldToEdit(task)
        }
    }
    return task
}


fun addTask(tasks: MutableList<Task>) {
    var priority = readTaskPriority()
    var ldt = readTaskDate()
    var lt = readTaskTime()
    var name: String = readTaskText()
    val task = Task(priority, name, ldt, lt)

    tasks.add(task)
}


fun readInputPositionInTaskList(maxTaskNb: Int): Int {

    try {
        println("Input the task number (1-$maxTaskNb):")
        val n = readln().toInt()

        if (n >= 1 && n <= maxTaskNb) {
            return n - 1
        } else {
            println("Invalid task number")
            return readInputPositionInTaskList(maxTaskNb)
        }
    } catch (e: NumberFormatException) {
        println("Invalid task number")
        return readInputPositionInTaskList(maxTaskNb)
    }
}


fun editTaskInPosition(tasks: MutableList<Task>, maxTaskNb: Int) {
    val position = readInputPositionInTaskList(maxTaskNb)
    readFieldToEdit(tasks.get(position))
    println("The task is changed")
}

fun editTask(tasks: MutableList<Task>) {
    if (tasks.isEmpty()) {
        println("No tasks have been input")
    } else {
        printTasks(tasks)
        val maxTaskNb = tasks.size
        editTaskInPosition(tasks, maxTaskNb)
    }
}

fun deleteTaskInPosition(tasks: MutableList<Task>, maxTaskNb: Int) {
    val position = readInputPositionInTaskList(maxTaskNb)
    tasks.removeAt(position)
    println("The task is deleted")
}

fun deleteTask(tasks: MutableList<Task>) {
    if (tasks.isEmpty()) {
        println("No tasks have been input")
    } else {
        printTasks(tasks)

        val maxTaskNb = tasks.size
        try {
            deleteTaskInPosition(tasks, maxTaskNb)
        } catch (e: NumberFormatException) {
            println("Invalid task number")
            deleteTaskInPosition(tasks, maxTaskNb)
        }
    }
}

fun readTaskText(): String {
    var name: String = ""
    println("Input a new task (enter a blank line to end):")

    var lineTask = readln()
    var line: String

    if (lineTask.trim().isBlank()) {
        println("The task is blank")
        main()
    } else {
        line = lineTask.trim()
        name += (line.trim())
    }
    do {
        line = readln()
        if (line.isNotBlank()) {
            name += ("\n" + line.trim())
        }

    } while (line.trim().isNotEmpty())

    return name
}

fun readTaskPriority(): String {
    var priority: String
    do {
        println("Input the task priority (C, H, N, L):")
        priority = readln()
        when {
            priority.uppercase() in arrayOf<String>("C", "H", "N", "L") -> return priority.uppercase()
        }
    } while (true)
}

fun readTaskDate(): kotlinx.datetime.LocalDate {
    println("Input the date (yyyy-mm-dd):")
    val dateStr = readln()
    val lDate: kotlinx.datetime.LocalDate
    try {
        val dateSplit = dateStr.split("-")
        lDate = LocalDate(dateSplit[0].toInt(), dateSplit[1].toInt(), dateSplit[2].toInt())
    } catch (e: IllegalArgumentException) {
        println("The input date is invalid")
        return readTaskDate()
    }
    return lDate
}

fun readTaskTime(): LocalDateTime {
    var dateTimeTask: LocalDateTime
    println("Input the time (hh:mm):")

    var timeStr = readln()
    val tStrSplit = timeStr.split(":")
    try {
        dateTimeTask =
            LocalDateTime(Year.now().value, 1, 1, tStrSplit[0].toInt(), tStrSplit[1].toInt())
    } catch (e: IllegalArgumentException) {
        println("The input time is invalid")
        return readTaskTime()
    }
    return dateTimeTask
}

fun endTask(tasks: MutableList<Task>) {
    println("Tasklist exiting!")
    saveTasks(tasks)
    exitProcess(0)
}

fun saveTasks(tasks: MutableList<Task>){
    val type = Types.newParameterizedType(List::class.java, Task::class.java)

    val moshi = Moshi.Builder()
        .add(TaskJsonAdapter())
        .add(KotlinJsonAdapterFactory())
        .build()

    val taskListAdapter = moshi.adapter<List<Task?>>(type)

    val jsonTasks = taskListAdapter.toJson(tasks)

    val jsonFile = File("tasklist.json")
    jsonFile.writeText(jsonTasks)
}

fun messageInvalid() {
    println("The input action is invalid")
}

fun pfx0(x: Int) = x.toString().padStart(2, '0')



class TaskJson(
    val priority: String,
    val text: String,
    val dateTask: String,
    val timeTask: String
)

class TaskJsonAdapter {
    fun getTimeTask(timeStr : String, localDate : kotlinx.datetime.LocalDate) : LocalDateTime{
        return LocalDateTime(
            localDate.year,
            localDate.monthNumber,
            localDate.dayOfMonth,
            timeStr.split(":")[0].toInt(),
            timeStr.split(":")[1].toInt(),
            0,0
        )
    }

    @FromJson
    fun taskFromJson(taskJson: TaskJson): Task {

        return Task(
            priority = taskJson.priority,
            text = taskJson.text,
            dateTask = taskJson.dateTask.toLocalDate(),
            timeTask = getTimeTask(taskJson.timeTask, taskJson.dateTask.toLocalDate())
        )

    }

    @ToJson
    fun taskToJson(task: Task): TaskJson {
        return TaskJson(
            priority = task.priority,
            text = task.text,
            dateTask = task.dateTask.toString(),
            timeTask = task.timeTask.toString().substring(11,16)
        )
    }
}