fun main() {
    var max = readln().toInt()
    var n = 0
    do {
        n = n + 1
        println(n * n)
    } while ((n + 1) * (n + 1) <= max)
}