package lambdas


fun buildString(
        builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}



fun buildStringWithResult(
        builderAction: StringBuilder.() -> Unit
) : String {
    val sb = StringBuilder()
    sb.builderAction()
    return sb.toString()
}

val appendExcl : StringBuilder.() -> Unit =
        { this.append("!") }

fun main(args: Array<String>) {
    val s = buildString({
        it.append("Hello, ")
        it.append("World!")
    })
    println(s)

    val sw = buildStringWithResult {
        append("lambda with result Hello, ").append("World!")
    }
    println(sw)

    val stringBuilder = StringBuilder("Hi")
    stringBuilder.appendExcl()
    println(stringBuilder)
    println(buildString(appendExcl))

    val map = mutableMapOf(1 to "one")
    println(map)
    map.apply { this[2] = "two"}
    println(map)
    with (map) { this[3] = "three" }
    println(map)

    val sumLambda = {a: Int, b: Int -> a + b}
    var numFun = ::sum
    println("sum fun result is ${numFun(1, 3)}")
    println("sumLambda fun result is ${sumLambda(1, 3)}")



}

fun sum(a: Int, b: Int): Int {
    return a + b
}