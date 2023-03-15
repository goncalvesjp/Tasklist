import java.lang.Math.abs
import java.util.Scanner

fun main() {
    val scanner  = Scanner(System.`in`)
    val line1 = scanner.nextLine().split(" ")
    val line2 = scanner.nextLine().split(" ")

    val x1 = line1[0].toInt()
    val y1 = line1[1].toInt()
    val x2 =  line2[0].toInt()
    val y2 =  line2[1].toInt()

    val y = abs(y2-y1)
    val x = abs(x2-x1)

    if( ((x==1) and (y==2)) or ((x==2) and (y==1)) ){
        println("YES")
    } else {
        println("NO")
    }
}