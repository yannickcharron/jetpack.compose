package ca.qc.cstj.kotlinplayground

fun main() {
    val listOfFruits = listOf("Fraise", "Bleuet", "Kiwi", "Framboises")
    val finder = Finder(list = listOfFruits)

    finder.findItem(element = "Kiwi") {
        println("Found $it")
    }

    finder("Bleuet") {
        println("$it")
    }
}

class Finder<T>(private val list: List<T>) {

    fun findItem(element: T, foundItem: ((element:T?) -> Unit)? = null) {
        val itemFoundList = list.filter {
            it == element
        }

        if(itemFoundList.isNotEmpty()) {
            foundItem?.invoke(itemFoundList.first())
        }
    }

    operator fun invoke(element: T, foundItem: ((element:T?) -> Unit)? = null) = findItem(element, foundItem)
}