fun main() {
    val str = readln()

    val myMap = mutableMapOf<Char, Int>()

    for(i in 0..str.lastIndex){
      when{
          myMap.containsKey(str[i]) -> myMap.replace(str[i], myMap.getValue(str[i]) + 1)
          else -> myMap[str[i]] = 1
      }
    }

    println( myMap.filter { (key, value) -> value == 1}.count())
}