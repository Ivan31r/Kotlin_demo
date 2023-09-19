package dataTypes

fun main() {
    longestSequence()

}

fun range() {
    val range = 100..200
    print(300 in range)

}

fun twoRange() {
    val intArray = IntArray(5) {
        readLine()!!.toInt()
    }
    val range1 = intArray[0]..intArray[1]
    val range2 = intArray[2]..intArray[3]
    println(intArray[4] in range1 || intArray[4] in range2)

    val time = readLine()!!.toInt()
    val workTime = 9..18
    val lunchTime = 13..14
    println(time in workTime && time !in lunchTime)
}

fun countTheNumbers() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    var counter = 0;
    for (number in a..b) {
        if (number % n == 0)
            counter++
    }
    print(counter)
}

fun longestSequence() {


}
