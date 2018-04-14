
interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
            println("I ${if(b) "get" else "lost"} focus.")


    fun showOff() = println("I'm focusable!")
}

class Buttons : Clickable, Focusable {
    override fun click() = println("I was clicked")

    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating() {}
    fun animateTwice() {}
}

class CircleAnimated : Animated() {
    override fun animate() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}


fun main(args: Array<String>) {
    val button = Buttons()
    button.showOff()
    button.setFocus(true)
    button.click()
    println(eval(Expr.Sum(Expr.Number(1), Expr.Sum(Expr.Number(3), Expr.Number(5)))))
}

sealed class Expr {
    class Number(val value: Int) : Expr()
    class Sum(val left: Expr, val right: Expr) : Expr()
}

fun eval(e: Expr): Int =
        when(e) {
            is Expr.Number -> e.value
            is Expr.Sum -> eval(e.left) + eval(e.right)
        }