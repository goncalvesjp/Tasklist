import java.lang.ArithmeticException

fun parseCardNumber(cardNumber: String): Long {
    if(((cardNumber[4].code) == 32)
        && ((cardNumber[9].code) == 32)
        && ((cardNumber[14].code) == 32)){
        return cardNumber.replace(" ","").toLong()
    } else {
        throw ArithmeticException("Card number is incorrect")
    }
}


