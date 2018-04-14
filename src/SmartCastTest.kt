abstract class Param<T>(val value: T)

class Password(value: String) : Param<String>(value) {

    // code that masks password and returns it
    val maskedValue: String
        get() {
            return "maskedPassword"
        }
}

class Username(value: String) : Param<String>(value)

fun main(args: Array<String>) {

    var params = mutableListOf(Password("password1"), Password("password2"), Username("whcai"))
    params.forEach { param ->
        if (param is Password){
            println("Password=${param.maskedValue}")
        } else if (param is Username){
            println("Username=${param.value}")
        }
    }

    println()

    params = mutableListOf(Password("password1"), Password("password2"))
    params.forEach { param ->
        param as Password
        println(param.value)
    }

}