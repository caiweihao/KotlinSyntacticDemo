import java.io.BufferedReader
import java.io.StringReader

fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    }
    catch (e: NumberFormatException) {
        return null
    }
    finally {
        reader.close()
    }
}

fun readNumbers(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        return
    } finally {
        reader.close()
    }

    println(number)
}

fun readNumberTest(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
        null
    }

    println(number)
}
fun main(args: Array<String>) {
    val reader = BufferedReader(StringReader("not a number"))
   readNumberTest(reader)
}