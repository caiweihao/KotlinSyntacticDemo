package inline

fun main(args: Array<String>) {
    noinlineOp { println("this is the actual noinlineOp function") }
    //inline fun like copy and past code to invoke position, like Macro(宏) in C
    //body of function is large not using inline
    inlineOp { println("this is the actual inlineOp function") }

}

fun noinlineOp(op:()->Unit){
    println("This is before lambda")
    op()
    println("this is after lambda")
}

inline fun inlineOp(op:()->Unit){
    //we can't actually store reference to that lambda function if want to inline it.
    println("This is before lambda")
    op()
    println("this is after lambda")
}