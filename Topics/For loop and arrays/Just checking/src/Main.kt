import java.util.Scanner

fun main() {
    val n = readln().toInt()
    var mylist = mutableListOf<Int>()
    repeat(n){
        val element = readln().toInt()
        mylist.add(element)
    }

    val line = readLine()!!

    val p =  line.first().toString().toInt()
    val m =  line.last().toString().toInt()

    if(mylist.contains(p) && mylist.contains(m)){
        println("YES")
    } else{
        println("NO")
    }

}