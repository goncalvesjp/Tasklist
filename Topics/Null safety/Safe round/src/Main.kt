fun main() {
    val number = readLine()?.toInt() ?: 0
    println((round(number)) ?: 0)
}

// do not change function below

fun round(number: Int): Int? {
    return if (number >= 1000) null else number
}