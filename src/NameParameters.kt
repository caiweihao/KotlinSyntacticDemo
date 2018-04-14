fun build(title: String, width: Int = 800, height: Int = 600) {
    println("title is $title width is $width, height is $height")
}

fun builds( width: Int = 800, height: Int = 600, length: Int) {
    println("length is $length width is $width, height is $height")
}
fun String.lastChar():  Char? = if(isNotEmpty()) this[length - 1] else null

fun isString(obj : Any?): Boolean {
    return when (obj) {
        is String -> true
        else -> false
    }
}



fun String.replaceSpaces(newChar : Char): String {
    return this.replace(' ', newChar)
}

fun main(args: Array<String>) {
    build("Rectangle")
    build(title = "Rectangle")
    build("Square", 100, 100) // equivalent
    build("Square", width = 100, height = 100) // equivalent
    build( width = 100, title = "Square")  // equivalent
    build(width = 100, height = 100, title = "Square")  // equivalent
    builds(100, 100, 100)
    println("".lastChar())
    println("AB".lastChar())
    println("A B".replaceSpaces('%'))
    println("A B".replaceSpaces('$'))
    println("A B".replaceSpaces('_'))
    println(null is String)
    println(isString(null))
    println(isString("ABC"))
    println(isString(123))

}