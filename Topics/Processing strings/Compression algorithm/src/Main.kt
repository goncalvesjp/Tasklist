fun main() {
    val str = readln()
    var count = 0

    for (i in str.indices){
        when{
            i == 0 -> count = 1
            i > 0 && (str[i] == str[i-1]) && (count > 0) -> count += 1
            i > 0 && (str[i] != str[i-1]) && (count >= 1) -> {print("${str[i-1]}$count"); count=1}
        }
    }
    print("${str[str.lastIndex]}$count")
}
