
class User(val id: Int, val name: String, val address: String)
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Name")
    }

    if (user.address.isEmpty()) {
        throw IllegalArgumentException(
                "Can't save user ${user.id}: empty Address")
    }

    // Save user to the database
}

fun User.saveUserLocalFunction() {
    fun User.validate(
                 value: String,
                 fieldName: String) {
        if(value.isEmpty()) {
            throw IllegalArgumentException("Can't save user $id: empty $fieldName")
        }
    }
    fun User.validate(
            value: Int,
            fieldName: String) {
        if(value < 0) {
            throw IllegalArgumentException("Can't save user $id: less than zero  $fieldName")
        }
    }
    validate(address, "address" )
    validate(name, "name")
    validate(id, "id")
}


fun outerFunction(param:Int){
    val outerVar = 11
    fun localFunction(){
        println(param)
        println(outer)
        println(outerVar)
    }
    localFunction()
}


var outer = 1000

fun main(args: Array<String>) {
    outerFunction(1)
    User(1, "whcai", "beijing").saveUserLocalFunction()
}