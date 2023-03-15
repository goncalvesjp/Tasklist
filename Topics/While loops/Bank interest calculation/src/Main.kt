fun findYears(depo: Double): Int {
    var deposit = depo
    val interestRate = 1.071
    val max = 700000
    var years = 0
    //
    // implement the while loop here
    while (deposit < 700000.0) {
        deposit = deposit * 1.071
        years += 1
    }
    //
    return years
}

//fun main() {
//    println(findYears(650000.0))
//}