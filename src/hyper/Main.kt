package hyper

fun main() {
    mapIterator()
}


fun wordsStartingWithTheSameLetter() {
    val words: List<String> = "fish fiacko feeling french".split(" ")
    val firstLetter = words.first().first()
    var needReset = false
    words.forEach { if (it.first() != firstLetter) needReset = true }
    println(if (needReset) "" else words.joinToString(separator = " ", prefix = "", postfix = ""))
}

fun mapIterator() {
    val map = mapOf(
        "NG" to "Nigeria",
        "AU" to "Australia",
        "CA" to "Canada",
        "BG" to "Bulgaria",
        "DE" to "Germany"
    )
    val mapIterator = map.iterator()
    val input = "CA".uppercase()
    while (mapIterator.hasNext()) {
        if (mapIterator.next().key.equals(input)) print(map.get(input))
    }
}

fun sequencesV2() {
    val list = "expetum axio lithigum magnum anima".split(" ").asSequence()
    println(list.filter { it.length > 5 }.map { it -> it.uppercase().reversed() }.take(3).toList())
}


open class Shape
class Rectangle : Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle"

fun printClassName(s: Shape) {
    println(s.getName())
}


fun palindromeInSequencesModule() {
    val input = "ana arara casa ovo radar reviver sator solos stats tenet xanax".split(" ").asSequence()
    input.asSequence().filter { it == (it.reversed()) }.count().apply { println(this) }
}

//
//open class Rectangle {
//    open fun draw() {
//        println("Rectangle.draw")
//    }
//}

interface Polygon {
    fun draw() {
        println("Polygon.draw")
    } // interface members are 'open' by default
}

//class Square() : Rectangle(), Polygon {
//     The compiler requires draw() to be overridden:
//    override fun draw() {
//        super<Rectangle>.draw() // call to Rectangle.draw()
//        super<Polygon>.draw() // call to Polygon.draw()
//    }
//}
//
//open class Shape {
//    open fun draw() {
//        println("Shape.draw")
//    }
//
//    fun fill() { /*...*/
//    }
//}
//
//class Circle() : Shape() {
//    override fun draw() {
//        println("Circle.draw")
//    }
//
//}
//
//open class Rectangle() : Shape() {
//    final override fun draw() {
//        println("Rectangle.draw")
//    }
//}
//
//open class Rectangle2() : Rectangle() {
//
//}

class Customer(name: String) {
    val customerKey = name.uppercase()
}

class Customer2(var name: String) {
    val customerKey = name.uppercase()
}

class InitOrderDemo(name: String) {
    val firstProperty: String = "First property: $name".also(::println)

    init {
        println("First initializer block that prints $name")
    }

    val secondProperty = "Second property: ${name.length}".also(::println)

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

fun l1() {
    Thread.sleep(100)
}

fun lExprV5() {
    val message = readLine()!!
    println(message).also { println("Note! I didn't die at the end of the Drive") }
}


fun lExprV4() {
    val microphone = Microphone()

    // Write scope function that receive new settings from standard input and set up them to the Microphone
    microphone.run {
        track = readLine()!!
        frequency = readLine()!!.toInt()
        effect = readLine()!!
        sensitivity = readLine()!!.toDouble()
    }

    println(microphone)
}

data class Microphone(
    var track: String = "",
    var frequency: Int = 0,
    var effect: String = "",
    var sensitivity: Double = 0.0
)

fun lExpV4() {
    val domains = readLine()!!.split(" ")
    val map = domains.map { it.lowercase() }.associateWith { s: String -> "[${s.lowercase().length}]" }
    println(domains.size)
    println(map)
}

data class Musician(var name: String = "", var band: String = "", var role: String = "")

//You have an instance of the Musician class. Try to write a chain of three scope functions, which could perform the following actions:
//First function body: print the data class and calculate the length of the field name.
//Second function body: pass the calculated length of the field name as a parameter, divide it by 4, and print the result on a new line.
//Third function body: pass the result of division of length by 4 as a parameter, add 10 to it, and pass this value to a variable num.
//After these steps, print the value of num in standard output on a new line.

fun lExpV3() {
    val musician = Musician()
    musician.apply {
        name = readLine()!!
        band = readLine()!!
        role = readLine()!!
    }
    var num = 0
    // Write your code here
    with(musician) {
        println(this)
        name.length
    }.let {
        println(it / 4)
        it / 4
    }.run {
        num = this + 10
        println(num)
    }

}

fun lExpV2() {
    val data = run {
        val day = readLine()
        val month = readLine()
        val year = readLine()
        "$month.$day.$year"
    }
    // Do not change the code below
    println(data)
}

fun lExpr() {
    val numbers = listOf(2, 5, 25, 1089, 4)
    val value = with(numbers) {
        val r = this
        println(this.drop(5))
        println(r)
        numbers.lastOrNull()
    }
    println(value)
    println(numbers)
}


fun extensionV1() {
    val hexNumberRegex = run {
        val digits = "0-9"
        val hexDigits = "A-Fa-f"
        val sign = "+-"

        Regex("[$sign]?[$digits$hexDigits]+")
    }
}

fun withExps() {
    val musicians = mutableListOf("Thom York", "Jonny Greenwood", "Colin Greenwood")
    val firstAndLast = with(musicians) {
        "First list element - ${first()}," +
                " last list element - ${last()}"
    }
    println(firstAndLast)
}

data class Spell(val name: String, val power: Int)

fun aggregatePart2V1() {
    val input = "expetum-98 patronus-23 Axio-89 lithigum-33 madriketom-76".split(" ")
    val spells = input.map { Spell(it.split("-")[0], it.split("-")[1].toInt()) }

    // write your code here
    val res = "Most powerful: ${spells.maxByOrNull { it.power }}-Least powerful: ${spells.minByOrNull { it.power }}"
    val list = readLine()!!.split(" ")
    list.sumOf { it.length }
    println(res)
}


val fibList = MutableList(1000) { 0 }
fun coolerFibonacci(n: Int): Int {
    if (n <= 0) return 0
    if (n == 1) return 1
    return if (fibList[n] != 0) fibList[n]
    else {
        fibList[n] = coolerFibonacci(n - 1) + coolerFibonacci(n - 2)
        fibList[n]
    }
}

fun everyNumber() {
    val list = readLine()!!.split(" ").map { it.toInt() }
    // write your code here
    val res = list.all { i -> i <= 20 && i % 2 == 0 }


    println(res)
}

fun contains() {
    val list = readLine()!!.split(" ")
    // write your code here

    val res = list.any { el -> el.equals("ABRACADABRA", true) }
    println(res)
}

fun corners() {
    var inputArray: Array<Array<String>> = arrayOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toTypedArray()
        inputArray += strings
    }
    println("${inputArray[0].first()} ${inputArray[0].last()}")
    println("${inputArray[inputArray.lastIndex].first()} ${inputArray[inputArray.lastIndex].last()}")

}

fun multiDimensionalArray() {
    var inputArray: Array<Array<String>> = arrayOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toTypedArray()
        inputArray += strings
    }
    // Do not change lines above
    // Write your code here
    println(inputArray[2].joinToString(", "))
}

fun counting() {
    val numbers = IntArray(readLine()!!.toInt()) {
        readLine()!!.toInt()
    }
    val repeatableNumber = readLine()!!.toInt()
    println(numbers.count { it == repeatableNumber })
}


fun checkTheNumbersV2() {
    val arr = " ${Array(readLine()!!.toInt()) { readLine() }.joinToString(separator = " ")} "
    val check = " ${readLine()} "
    println(if (check in arr || check.reversed() in arr) "NO" else "YES")
}


fun checkTheNumbers() {
    var numbers = IntArray(readLine()!!.toInt()) {
        readLine()!!.toInt()
    }
    val sequence = readLine()!!.split(" ").map { it.toInt() }
    var flag = false
    for (iterator in 0 until numbers.size - 1) {
        if (numbers[iterator] == sequence[0].toInt() && numbers[iterator + 1] == sequence[1].toInt()) {
            flag = true
        }
    }
    numbers.reverse()
    for (iterator in 0 until numbers.size - 1) {
        if (numbers[iterator] == sequence[0].toInt() && numbers[iterator + 1] == sequence[1].toInt()) {
            flag = true
        }
    }
    println(if (flag) "NO" else "YES")
}

fun nullableCollections2() {
//    val inputSequence = readLine()
//    val number = readLine()!!.toInt()
//    val split = inputSequence!!.split(" ").map { it.toInt() }.toMutableList()
//    print(split.getOrNull(number)) //v1

    print(readLine()!!.split(' ').getOrNull(readLine()!!.toInt())) //v2
}

fun nullableCollections() {
    val list = listOf(0, 1, 1, 2, 5, 7, 6)
    val num = list.firstOrNull { it > 3 }
    val num1 = list.lastOrNull { it == 1 }
    val num2 = list.firstOrNull()
    println(num)
    println(num1)
    println(num2)
}

fun divisionProblem(first: Set<Int>, second: Set<Int>): Set<Int> {
//    val resultSet = mutableSetOf<Int>()
//    first.forEach { el -> if (el % second.size == 0) resultSet += el } //v1
//    return resultSet
//    return first.filter { i -> i % second.size == 0 }.toSet()           //v2
    return first.filter { it % second.size == 0 }.toSet()                   //v3
}

fun checkHeightIterator(iterator: Iterator<Int>) {
//    while (iterator.hasNext()){
//        val height = iterator.next()
//        println(if (height in 145..210) "You can go!" else "Sorry, not today")
//    }
    iterator.forEach { i -> if (i in 145..210) print("You can go!") else print("Sorry, not today") }

}

fun checkHeight() {
    val list = readLine()!!.split(" ").map(Integer::parseInt).toList()
    checkHeightIterator(list.iterator())
}


fun indexes(products: List<String>, product: String) {
    val toMutableList = product.toMutableList()

//    println(products.indices.filter { products[it] == product }.joinToString(" "))
    var result = ""
    for (index in products.indices) {
        if (products[index] == product) {
            result += " $index"
        }
    }
    println(result)
}

fun numberOfOccurrences(strings: List<String>, str: String): Int {
    var result = 0
    strings.forEach { if (it.equals(str, true)) result++ }
    return result
}
//fun numberOfOccurrences(strings: List<String>, str: String) = strings.count { it == str }
//fun numberOfOccurrences(strings: List<String>, str: String) = strings.count(str::equals)


fun solution(numbers: List<Int>): Int {

    var result = 0
//    for (number in numbers){
//        result+=number
//    }
//    return result

    numbers.forEach { result += it }
    return result

}


fun twoNumbersInARow() {
    val size = readLine()!!.toInt()
    val elements = mutableListOf<Int>()
    for (ind in 1..size) {
        elements.add(readLine()!!.toInt())
    }
    val numbers = readLine()!!.split(" ").toMutableList()
    println(
        if (numbers[0] + numbers[1] in elements.joinToString("")
            || (numbers[1] + numbers[0] in elements.joinToString(""))
        )
            "NO"
        else "YES"
    )

}

fun addingLists() {
    val firstList = readLine()!!.split(' ').map { it }.toMutableList()
    val secondList = readLine()!!.split(' ').map { it }.toMutableList()
    // do not touch the lines above
    println((firstList + secondList).joinToString())
}

fun createList() {
    val capitals = mutableListOf("Tokyo", "Moscow", "Paris", "Washington", "Beijing")
}

fun mutableList() {
    val mutList = mutableListOf<Char>('!', '@', '#', '$')
    println(mutList[mutList.size - 1])
    println(mutList[mutList.size - 2])
//    println(mutList[-1])
//    println(mutList[mutList.size + 1])
    println(mutList[mutList.lastIndex])
    println(mutList.last())
//    println(mutList[mutList.size])
}

fun equalLists() {
    val numbers1 = mutableListOf<Int>(1, 2, 3, 4)
    val numbers2 = mutableListOf<Int>(1, 2, 3, 4)
    val numbers3 = mutableListOf<Int>(4, 3, 2, 1)
    val numbers4 = mutableListOf<Int>(1, 2, 3)

    println(numbers4 == numbers2)
    println(numbers1 == numbers1)
    println(numbers1 == numbers2)
    println(numbers2 == numbers3)
}

fun regex1() {
    val regex = "\\s+".toRegex()
    println(regex)

}

fun bitOperations2() {
    val n1 = 7
    val n2 = 1

    val result = n1 and n2
    println(result)
}

fun bitOperations1() {
    val n = 15
    val result = n shl 2 shl 1
    println(result)
}


private fun substringsTest() {
    println("content".substringAfter("t") + "1")

//    println("content".substring(-1,-1))

    println("content".substring(0, 1) + "2")

    println("content".substring(0, 0) + "3")

    println("content".substringBefore("c") + "4")

    println("content".substring(1, 1) + "5")
}

fun url(host: String = "localhost", port: Int = 443): String {
    return "https://$host:$port"
}

fun mutabilityObjects() {
    var a: Int = 100
    val anotherA: Int = a
    println(a == anotherA)
    println(a === anotherA)
    a = 200
    println(a)
    println(anotherA)

    println(a == anotherA)
    println(a === anotherA)
    println("-----------------")
    var d1: Double = 1.5
    val d2 = d1
    println(d1 === d2) // true
    d1 += 1            // d1 is 2.5 now
    println(d1 === d2) // false
    println(d1)
    println(d2)
}

fun getLength(input: String?): Int {
    return when {
        input != null -> input.length
        else -> -1
    }
}

fun safeNullCast() {
    val obj: Any = 123
    val str: String? = obj as? String // Safe (nullable) cast operator
    println("----")
    println(str?.uppercase())
    println("----")

}

fun <T> exampleFunction(obj: Any) {
    val tObj: T? = obj as? T
    if (tObj != null) {
        println("type T")
    } else {
        println("not type T =(")

    }
}

fun countStrings(list: List<Any>): Int {
    var counter = 0
    for (i in list) {
        if (i is String) {
            counter++
        }
    }
    return counter
}

fun checkType(obj: Any) {
    if (obj is String) {
        println("$obj is a String")
    } else if (obj !is Int) {
        println("$obj is not a Int")
    } else {
        println("$obj Is an Int")
    }
}

fun indicesInString() {
    val rainbow = "ROYGCBV"
    for (index in rainbow.indices) {
        println("${index + 1}: ${rainbow[index]}")
    }
}

fun determineTheValue() {
    val chars = charArrayOf('H', 'Y', 'P', 'E', 'R', '-', 'S', 'K', 'I', 'L', 'L')

    val stringFromChars = String(chars)

    val strings = stringFromChars.split("-")
    println(strings)
}

fun isPalindrome() {
    var inputString = readLine()
    val reversed = inputString?.reversed()
    println(if (inputString.equals(reversed)) "yes" else "no")
}

fun simpleEncoding() {
    val input = readLine().toString()
    var result = ""
    var counterOfRepeatable = 1
    var outerIndex = 0
    for (index in 0 until input.length - 1) {
        outerIndex++
        if (input[index] == input[index + 1]) {
            counterOfRepeatable++
        } else {
            result += "${input[index]}$counterOfRepeatable"
            counterOfRepeatable = 1
        }
    }
    result += "${input[outerIndex]}$counterOfRepeatable"
    println(result)
}

fun simpleEnc2() {
    var dna = readLine().toString()
    val pack = mutableListOf<String>()

    while (dna.length > 0) {
        val char = dna.first()
        val num = dna.takeWhile { it == char }.length
        pack.add("$char$num")
        dna = dna.drop(num)
    }
    println(pack.joinToString(""))
}


