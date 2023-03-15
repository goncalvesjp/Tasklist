fun main() {
    val n = readln()
    var sum1: Int = 0
    var sum2: Int = 0
    for (x in 0..n.lastIndex / 2) {
        sum1 += (n[x]).digitToInt()
        sum2 += (n[x + n.lastIndex / 2 + 1]).digitToInt()
    }

    if (sum2 == sum1) {
        println("YES")
    } else {
        println("NO")
    }
}