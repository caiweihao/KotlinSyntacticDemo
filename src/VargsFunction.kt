fun main(args: Array<String>) {
    val list = listOf("args: ", *args)
    println(list)
    println("12.345-6.A C".split("\\.|-| ".toRegex()))
    println("12.345-6.A DEF".split(".", "-", " "))
    parsePathRegex("/Users/whcai/kotlin-book/chapter1.adoc")


    val kotlinLogo = """| //
                   .|//
                   .|/ \"""
    println(kotlinLogo.trimMargin("."))

}

fun parsePathRegex(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()
    val matchResult = regex.matchEntire(path)
    if (matchResult != null) {
        val (directory, filename, extension) = matchResult.destructured
        println("Dir: $directory, name: $filename, ext: $extension")
    }
}

fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")

    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")

    println("Dir: $directory, name: $fileName, ext: $extension")
}