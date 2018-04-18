package reflections

import kotlin.reflect.full.memberProperties

class Person(val name: String, val age: Int)

/**
 * NOTE: This example uses reflection, which is not supported in the "Try Kotlin" online environment.
 * If you'd like to run it, please download the source code from https://www.manning.com/books/kotlin-in-action
 * and run it on your local machine.
 */
fun main(args: Array<String>) {
    val person = Person("Alice", 29)
    val kClass = person.javaClass.kotlin
    println(kClass.simpleName)
    kClass.memberProperties.forEach { println(it.name) }

    val kFunction = ::foo
    kFunction.call(32)
    val kProperty = ::counter
    println("before is ${kProperty.get()}")
    kProperty.setter.call(21)
    println("after is ${kProperty.get()}")

    val memberProperty = Person::age
    println(memberProperty.get(person))
}
var counter = 0
fun foo(x: Int) = println(x)