package filter


data class Person(val name: String, val age: Int)

val canBeInClub27 = { p: Person -> p.age <= 27 }

fun main(args: Array<String>) {
    val numbers = mapOf( 0 to "Zero", 1 to "one")
    println(numbers.mapValues {  it.value.toUpperCase() })

    val people = listOf(Person("Alice", 27), Person("Bob", 31), Person("Carol", 31))
    println(people.all(canBeInClub27))
    println(people.find(canBeInClub27))
    println(people.groupBy{it.age})

    val list = listOf("a", "ab", "b")
    println(list.groupBy(String::first))

    val strings = listOf("abcd", "def")
    println(strings.flatMap { it.toList() })

    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
            Book("Mort", listOf("Terry Pratchett")),
            Book("Good Omens", listOf("Terry Pratchett",
                    "Neil Gaiman")))
    println(books.flatMap { it.authors }.toSet())
}

class Book(val title: String, val authors: List<String>)