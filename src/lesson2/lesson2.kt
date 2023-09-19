package lesson2

fun main() {

}

 fun elviseOperator() {
    var ok: String? = null
    println(ok?.length?.toLong())
    println(ok?.length ?: return)
    println(ok?.length ?: throw NullPointerException())
}