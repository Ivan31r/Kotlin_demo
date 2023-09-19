package collections

fun main() {


    var booksToRead = listOf<String>("I","b","a")
    println(booksToRead)

    var newBook = booksToRead + "Ho-ho"  //никаких add\put. Кажется наркоманией.
    println(newBook)

    newBook = newBook.plus("ho-ho2") //под капотом создается новый лист.
    println(newBook)

    booksToRead = booksToRead + "plus" - "I"
    println(booksToRead)

    var v = mutableListOf<String>("a","b","c")
    v.add("d")
    println(v)
    println(v + "dd")

    println(v[0])
    println(v.get(0))

    println(booksToRead[0])
    println(booksToRead.get(0))

    booksToRead.forEach { el -> print(el) }
    booksToRead.forEach (::println)
    v.forEach { t->t.removePrefix("a")}
    v.forEach(::print)
    v.map { t->t + "THE" }
    print(v)
    var sub = booksToRead.map { t-> t + " THE" }
    var sub2 = booksToRead.map { t-> "$t THE" }
    print(sub)

    booksToRead = booksToRead.map { res -> res + "RES" }
    println(" _____________ ")
    print(booksToRead)


}