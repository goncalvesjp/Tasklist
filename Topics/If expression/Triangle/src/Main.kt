
fun main() {
    val a = readln().toUInt()
    val b = readln().toUInt()
    val c = readln().toUInt()


    val result =
            if ((a < b + c) xor (b < a + c) xor (c < a + b)) {
                "YES"
            } else {
                "NO"
            }

    println(result)

}