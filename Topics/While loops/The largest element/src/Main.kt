fun main() {
    var max = 0
    do {
      val n = readln().toInt()
      if (n>max){
          max = n
      }
    } while (n!=0)

    println(max)
}