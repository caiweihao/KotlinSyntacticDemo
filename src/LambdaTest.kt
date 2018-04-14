class Views {
    fun setOnclickListener(onclickListener: OnclickListener) {
        onclickListener.onClick(this);
    }

}

interface OnclickListener{
    fun onClick(views: Views)
}

class MyClick : OnclickListener {
    override fun onClick(views: Views) {
        print("views click")
    }
}

fun main(args: Array<String>) {
    val views = Views()
    views.setOnclickListener(onclickListener = MyClick())
}