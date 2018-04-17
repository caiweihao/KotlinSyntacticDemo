package safe.call

class Address(val streetAddress: String, val zipCode: Int,
              val city: String, val country: String)

class Company(val name: String, val address: Address?)

class Person(val name: String, val company: Company?)

fun Person.countryName(): String {
    val country = this.company?.address?.country
    return country ?: "Unknown"
}

fun strLenSafe(s: String?): Int = s?.length ?: 0

fun printShippingLabel(person: Person) {
    val address = person.company?.address
            ?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

fun main(args: Array<String>) {

    println(strLenSafe(null))
    println(strLenSafe("abc"))

    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = Person("Dmitry", jetbrains)
    println(person.countryName())
    printShippingLabel(person)
    printShippingLabel(Person("Alexey", null))
}