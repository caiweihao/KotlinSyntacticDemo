package numbsers
data class Person(val name: String,
                  val age: Int? = null) {

    fun isOlderThan(other: Person): Boolean? {
        if (age == null || other.age == null)
            return null
        return age > other.age
    }
}

fun foo(l: Long) = println(l)

fun fail(message: String): Nothing {
    throw IllegalStateException(message)
}


fun main(args: Array<String>) {
    println(Person("Sam", 35).isOlderThan(Person("Amy", 42)))
    println(Person("Sam", 35).isOlderThan(Person("Jane")))
    val x = 1
    println(x.toLong() in listOf(1L, 2L, 3L))
    val b: Byte = 1
    val l = b + 1L
    foo(l)
    foo(42)
    fail("Error occurred")
}
