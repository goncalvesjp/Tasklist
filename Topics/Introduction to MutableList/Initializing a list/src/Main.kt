fun main() {
    val numbers = (1..100)
        .toMutableList()
        .mapNotNull { if ( it != 1 && it != 10 && it != 100) 0 else it }


    // do not touch the lines below
    println(numbers.joinToString())

}

