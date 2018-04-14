fun test() {
    println("test")
}

fun main(args: Array<String>) {
    print("${args.size}")
    println()
    test()
    var b : String? = "xyz"
    val y = b?.length
    var x = b?.length ?: 0
}