fun main() {
    val n = readln().toInt()
    when {
        n < 0 -> println("negative")
        n > 0 -> println("positive")
        n == 0 -> println("zero")
    }
}