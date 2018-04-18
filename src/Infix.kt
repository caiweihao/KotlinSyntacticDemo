package infix

infix fun String.repeat(times : Int) : String {
    val builder = StringBuilder()
    for (i in 0 until times) {
        builder.append(this)
    }
    return builder.toString()
}

fun main(args: Array<String>) {
    val str = "hello"
    println(str repeat 4)
    println(str.repeat(4))
}