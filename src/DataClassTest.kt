data class Client(val name: String, val postalCode: Int)
class CountingSet<T>(
        val innerSet: MutableCollection<T> = HashSet<T>()
) : MutableCollection<T> by innerSet {

    var objectsAdded = 0

    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}
fun main(args: Array<String>) {
    val client1 = Client("Alice", 23451)
    println(client1.copy(postalCode = 124))
    val counterSet = CountingSet(mutableSetOf(4, 5, 6))
    counterSet.addAll(listOf(1, 1, 2))
    println("${counterSet.objectsAdded} objects were added, ${counterSet.size} remain")

}