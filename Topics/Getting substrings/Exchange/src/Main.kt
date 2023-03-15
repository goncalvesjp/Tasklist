fun main() {
    var value = readln()

    println(
            value.substring(value.lastIndex)
                    + value.substring(1, value.lastIndex)
                    + value.first()
    )

}
