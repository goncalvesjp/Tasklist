// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val nullString1: String? = null
    val nullString2: String? = "notnull"
   // println(nullString1?.isEmpty()==true)
    println(nullString1?.isEmpty()!=true)//
   // println(nullString1?.isEmpty()==false)
    println(nullString1?.isEmpty()!=false)//
    println()
    //println(nullString2?.isEmpty()==true)
    println(nullString2?.isEmpty()!=true)
    //println(nullString2?.isEmpty()==false)
    println(nullString2?.isEmpty()!=false) // ok
}
