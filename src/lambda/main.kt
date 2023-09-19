package lambda

fun main(){

}

fun l1(){
    val lambda: (Int, Int) -> Int = { a, b -> a + b }
    val lambdaWithReceiver: Int.(Int) -> Int = { a -> this + a }

}