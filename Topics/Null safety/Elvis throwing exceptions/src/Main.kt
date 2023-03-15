fun main() {
    val line = readLine() // you need to add something
    line?.length?:throw IllegalStateException()
    println("Elvis says: $line")
}