import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val n = scanner.nextLine().toInt()
    val alist = mutableListOf<Int>()
    repeat(n){
        var element = scanner.nextLine().toInt()
        alist.add(element)
    }

    val p = scanner.nextInt()
    val m = scanner.nextInt()

    if(alist.contains(p) and alist.contains(m)) {
        println("YES")
    } else {
        println("NO")
    }
}