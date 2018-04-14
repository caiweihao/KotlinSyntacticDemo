package syntax.lambda

data class Person(val name: String, val age: Int)

fun printMessagesWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun main(args: Array<String>) {
    val sum = {x: Int, y: Int ->
        println("computing the sum of $x and $y")
        x + y
    }
    print(sum(2, 3))

    run {
        println(42)
    }

    val people = listOf(Person("Alice", 29), Person("Bob", 31))
    val names = people.joinToString(separator = " ",
            transform = { p: Person -> p.name })
    println(names)
    var errors = listOf("403 Forbidden", "404 Not Found")
    printMessagesWithPrefix(errors, "Error:")

    run { salute() }

    run(::salute)

    val cratePerson = ::Person
    println(cratePerson("whcai", 30))

}

fun salute() = println("Salute!")