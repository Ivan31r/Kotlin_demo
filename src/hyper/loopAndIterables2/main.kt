package hyper.loopAndIterables2

fun findLongestByIterator(strIterator: Iterator<String>): String {
    var longestString: String = ""
    strIterator.forEach { if (it.length > longestString.length) longestString = it }
    return longestString

//    var longestString: String = ""
//    while (strIterator.hasNext()) {
//        val next = strIterator.next()
//        if (next.length > longestString.length) {
//            longestString = next
//        }
//    }
//    // write your code here
//    return longestString

}

fun main() {
    val words: List<String> = readLine()!!.split("\\s+".toRegex())
    println(findLongestByIterator(words.iterator()))
}