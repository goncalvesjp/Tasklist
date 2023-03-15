val lambda : (Int) -> Int = {x -> (a*x*x+b*x+c) }


//fun placeArgument2( a:Int,b:Int,c:Int, f: (Int, Int ,Int,Int) -> Int): (Int) -> Int {
//    return { x-> f(a,b,c,x) }
//}
//fun polynom2(a: Int, b: Int, c:Int, x:Int) = (a*x*x+b*x+c)
//
//
//
//val lambda : (Int) -> Int =  placeArgument2(1,2,3,::polynom2)

//
//fun main(){
//    println(lambda(4))
//}