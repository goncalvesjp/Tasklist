fun main() {
     val n = readln().toInt()
    val elements = mutableListOf<Int>()
    repeat(n){
        val e = readln().toInt()
        elements.add(e)
    }

    var max = -1
    var position = -1

    for (i in 0 until elements.size) {
        if (elements[i] > max) {
            max = elements[i]
            position = i
        }
    }
    println(position)
}
