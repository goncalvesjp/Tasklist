fun main() {
    val ticketNumber = readln()
    var sumFirstNumbers = 0
    var sumLastNumbers = 0

   for(i in 0..2){
       sumFirstNumbers+= (ticketNumber[i]).digitToInt()
   }

    for(i in ticketNumber.lastIndex downTo ticketNumber.lastIndex-2){
        sumLastNumbers+= (ticketNumber[i]).digitToInt()
    }

   if(sumFirstNumbers == sumLastNumbers){
       println("Lucky")
   } else{
       println("Regular")
   }
}