import java.util.TreeMap

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "$i FizzBuzz "
    i % 3 == 0 -> "$i Fizz "
    i % 5 == 0 -> "$i Buzz "
    else -> "$i "
}

fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
fun isNotDigit(c: Char) = c !in '0'..'9'

fun main(args: Array<String>) {
    for (i in 100 downTo 1 step 2) {
        println(fizzBuzz(i))
    }

    val binaryReps = TreeMap<Char, String>()

    for (c in 'A'..'F') {
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }

    for ((letter, binary) in binaryReps) {
        println("$letter = $binary")
    }
    println(isLetter('q'))
    println(isNotDigit('x'))
    println(recognize('8'))
}

fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It's a digit!"
    in 'a'..'z', in 'A'..'Z' -> "It's a letter!"
    else -> "I don't know…​"
}