fun main() {
    val n = readln().toInt()
    var listN = mutableListOf<Int>()
    repeat(n){
        listN.add(readln().toInt())
    }
    val m = readln().toInt()
    println(
            when{
                listN.contains(m) -> "YES"
                else -> "NO"
            }
    )
}