fun main() {
    val number = readln().toInt()

    println(
            when {
                (number > -15) and (number <= 12) -> "True"
                (number > 14) and (number < 17) -> "True"
                number >= 19 -> "True"
                else -> "False"
            }
    )
}