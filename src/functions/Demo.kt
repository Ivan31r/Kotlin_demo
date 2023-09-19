package functions

fun main() {
    var s = "FIVE"
    var f = discountForCouponCode(s)
    println(f.invoke(20.0))

    val applyDiscount: (Double) -> Double = { price: Double -> price - 5.0 }
    val applyDiscount2: (Double) -> Double = { it - 5.0 } //неявный параметр
    println(applyDiscount.invoke(20.1))

    var x = calculateTotal(20.0, discountForCouponCode(s))
    println(x)
    val five = calculateTotal(20.0) { price -> price - 5.0 }
    println(five)

    printSubtotal{pr -> pr-5.0} //казалось бы была просто функция, теперь это лямбда и не нужны скобки для параметров\аргументов

}

fun discountForCouponCode(couponCode: String): (Double) -> Double = when (couponCode) {
//    "FIVE" -> ::discountFiveDollars
//    "TAKE_10" -> ::discountTenPercent
//    else -> ::noDiscount
    "FIVE_BUCKS" -> { price -> price - 5.0 }
    "TAKE_10"    -> { price -> price * 0.9 }
    else         -> { price -> price }
}

fun discountFiveDollars(price: Double): Double = price - 5.0
fun discountTenPercent(price: Double): Double = price * 0.9
fun noDiscount(price: Double): Double = price

fun calculateTotal(initialPrice: Double,applyDiscount: (Double) -> Double):Double{
//    val priceAfterDicsount = applyDiscount.invoke(initialPrice)
    val priceAfterDicsount = applyDiscount(initialPrice)

    val total = priceAfterDicsount * 0.9

    return total
}

fun printSubtotal(applyDiscount: (Double) -> Double) {
    val result = applyDiscount(20.0)
    val formatted = "$%.2f".format(result)
    println("A $20.00 haircut will cost you $formatted before tax.")
}

