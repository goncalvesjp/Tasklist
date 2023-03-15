import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var st = mutableListOf<String>()

    while (scanner.hasNextLine()){
        var line = scanner.nextLine()
        if(line == "")
            break
        var scannerWord = Scanner(line)
        while (scannerWord.hasNext()){
            st.add(scannerWord.next())
        }
    }

    scanner.close()

    for (x in st) {
        println(x)
    }
}