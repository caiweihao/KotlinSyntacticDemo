package operator

import java.math.BigDecimal

data class Point(private val x: Int,private val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    operator fun times(times: Int): Point {
        return Point(x * times, y * times)
    }

    operator fun inc() : Point {
        return Point(x  + 1, y  + 1)
    }

    operator fun times(times: Float): Point {
        return Point((x * times).toInt(), (y * times).toInt())
    }

    operator fun unaryMinus(): Point {
        return Point(-x, -y)
    }

}

operator fun BigDecimal.inc() = this + BigDecimal.ONE


operator fun Char.times(count : Int): String {
    return toString().repeat(count)
}

fun main(args: Array<String>) {
    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
    var p1 = Point(10, 20)
    var p2 = Point(30, 40)
    p1 += p2
    println(p1 + p2)
    println(p1 * 4)
    println(p2 * 2.5f)
    println(-p2)
    println('a' * 30)

    println(0x0F and 0xF0)
    println(0x0F or 0xF0)
    println(0x1 shl 4)

    val numbers = ArrayList<Int>()
    numbers += 1
    println(numbers[0])

    val list = arrayListOf(1, 2)
    list += 3
    val newList = list + listOf(4, 5)
    println(list)
    println(newList)

}