data class Point(val x: Int, val y: Int) {
    operator fun plus(plus: Point) : Point {
        return Point(plus.x + x, plus.y + y)

    }
    operator fun minus(minus: Point) : Point {
        return Point( x - minus.x, y - minus.y)
    }
    operator fun times(times : Int) : Point{
        return Point( x * times, y * times)
    }
}
fun main(args: Array<String>) {
    var one = Point(1, 1)
    var two = Point(2, 2)
    println(one + two)
    one += two
    println(one)
    one = one - two * 2
    println(one)
}