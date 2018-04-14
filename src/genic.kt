package generic


fun main(args: Array<String>) {
    val letters = ('a'..'z').toList()
    println(letters.slice<Char>(0..2))
    println(letters.slice(10..13))

    val items = listOf("one", 2, "three")
    println(items.filterIsInstance<String>())
}