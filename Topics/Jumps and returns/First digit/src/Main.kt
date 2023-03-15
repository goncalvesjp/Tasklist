fun main() {
    val str = readln()
    for(c in str){
        when{
            c.isDigit() -> {
                println(c)
                break
            }
            else -> continue
        }
    }

}