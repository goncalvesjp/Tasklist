fun main() {
    val str = readln()
    var s: String = ""
    for (x in str) {
        s = s + x + x
    }
    println(s)
}