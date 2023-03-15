fun main() {
    // write your code here
    val a = readln().toInt()
    val b = readln().toInt()
    val h = readln().toInt()

    if ((h <= b) and (h >= a)) {
        println("Normal")
    } else if (h < b) {
        println("Deficiency")
    } else if (h > b) {
        println("Excess")
    }

}