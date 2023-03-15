fun main() {
    val n = readln().toInt()
    var tab = mutableListOf<Int>()
    repeat(n){
        val element = readln().toInt()
        tab.add(element)
    }
    val m = readln().toInt()
    if(tab.count { x -> x == m } == 0){
        println("NO")
    } else{
        println("YES")
    }
}