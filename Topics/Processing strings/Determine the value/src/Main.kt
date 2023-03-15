// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val chars = charArrayOf('H', 'Y', 'P', 'E', 'R', '-', 'S', 'K', 'I', 'L', 'L' )

    val stringFromChars = String(chars)

    val strings = stringFromChars.split("-")

    println(strings[1])
}
