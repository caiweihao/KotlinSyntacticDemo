package lazy

class Email { /*...*/ }
fun loadEmails(person: Person): List<Email> {
    println("Load emails for ${person.name}")
    return listOf(/*...*/)
}

class Person(val name: String) {
    private var _emails: List<Email>? = null

    val emails: List<Email>
        get() {
            if (_emails == null) {
                _emails = loadEmails(this)
            }
            return _emails!!
        }
}

fun loadLazyEmails(person: LazyPerson): List<Email> {
    println("Load lazy emails for ${person.name}")
    return listOf(/*...*/)
}
class LazyPerson(val name: String) {
    val emails by lazy { loadLazyEmails(this) }
}

class Persons {
    private val _attributes = hashMapOf<String, String>()

    fun setAttribute(attrName: String, value: String) {
        _attributes[attrName] = value
    }

    var name: String by _attributes

    var company: String by _attributes
}

fun main(args: Array<String>) {
    val pl = LazyPerson("Alice")
    println(pl.emails)
    println(pl.emails)

    val p = Persons()
    val data = mapOf("name" to "Dmitry", "company" to "JetBrains")
    for ((attrName, value) in data)
        p.setAttribute(attrName, value)
    println(p.name)
    println(p.company)
}
