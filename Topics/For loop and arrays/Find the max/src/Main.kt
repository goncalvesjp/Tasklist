fun main() {
    val n = readln().toInt()
    var tab = arrayListOf<Int>()

    repeat(n) {
        tab.add(readln().toInt())
    }

    var max = -1
    var maxIndex = -1
    for (i in 0..tab.lastIndex) {
        when {
            tab[i] > max -> {
                max = tab[i]; maxIndex = i
            }
            tab[i] <= max -> continue
        }
    }
    println(maxIndex)
}