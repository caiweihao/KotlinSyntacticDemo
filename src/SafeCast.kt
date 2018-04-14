package safe.cast

class Person(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? Person ?: return false


        return otherPerson.firstName == firstName &&
                otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
            firstName.hashCode() * 37 + lastName.hashCode()
}

class Persons(val name: String?)


fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("send email to $email")
}


fun yellAtSafe(customer: Persons) {
    println((customer.name ?: "Anyone").toUpperCase() + "!!!")
}

fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We're ${percent}% done!")
}


fun main(args: Array<String>) {
    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))
    ignoreNulls("abc")
    var email: String? = "yole@example.com"
    email?.let { sendEmailTo(it) }
    email = null
    email?.let { sendEmailTo(it) }

    verifyUserInput(" ")
    verifyUserInput(null)
    printHashCode(null)
    printHashCode("123")
    printHashCode(123)
    yellAtSafe(Persons(null))
    yellAtSafe(Persons("123"))
    showProgress(145)

}

fun <T> printHashCode(t: T) {
    println(t?.hashCode())
}


fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}