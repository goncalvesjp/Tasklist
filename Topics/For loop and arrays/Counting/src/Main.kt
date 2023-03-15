fun main() {
    val n = readln().toInt()
    var tab = mutableListOf<Int>()
    repeat(n){
        val element = readln().toInt()
        tab.add(element)
    }
    val m = readln().toInt()

    println(tab.count { x -> x == m })

}