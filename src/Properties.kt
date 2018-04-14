fun getFacebookName(accountId: Int) = "fb:$accountId"

interface Users {
    val nickname: String
}
class PrivateUser(override val nickname: String) : Users

class SubscribingUser(val email: String) : Users {
    override val nickname: String
        get() = email.substringBefore('@')
}

class FacebookUser(val accountId: Int) : Users {
    override val nickname = getFacebookName(accountId)
}

fun main(args: Array<String>) {
    println(PrivateUser("test@kotlinlang.org").nickname)
    println(SubscribingUser("test@kotlinlang.org").nickname)
    println(FacebookUser(123).nickname)

    val user = NickUser("Alice")
    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

    val lengthCounter = LegnthCounter()
    lengthCounter.addWord("Hi!")
    println(lengthCounter.counter)
    lengthCounter.addWord("DDD")
    println(lengthCounter.counter)
}

class LegnthCounter {
    var counter: Int = 0
        private set
    fun addWord(word: String) {
        counter += word.length
    }
}

class NickUser(val name: String) {
    var address: String = "unspecified"
        set(value: String) {
            println("""
                Address was changed for $name:
                "$field" -> "$value".""".trimIndent())
            field = value
        }

}
