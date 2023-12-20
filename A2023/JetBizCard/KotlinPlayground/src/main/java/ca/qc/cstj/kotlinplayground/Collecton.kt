package ca.qc.cstj.kotlinplayground

fun main() {

    println("Bonjour d'une bibliothèque Kotlin")
    listExperimentation()
    setExperimentation()
    mapExperimentation()
}

fun listExperimentation() {
    val newList = mutableListOf<String>()
    newList.add("Hey")
    newList.add("There")
    for(i in 1..10) {
        newList.add(i, "Hey $i")
    }
    println(newList)

    val emptyList = emptyList<String>()

    val listOfNames = listOf("Jessica", "Noémie", "Jessica", "Émilie", "Jessica")

    val found = listOfNames.filter {
        it.endsWith("ie")
    }

    println(found)
}

fun setExperimentation() {
    //Unique Element et Order isn't important
    val mySet = setOf("US", "CA", "AU")
    val myMutableSet = mutableSetOf(1,2,3,4,5)
    myMutableSet.add(3)
    println(myMutableSet)

    val emptySet = emptySet<Int>()
}

fun mapExperimentation() {
    //Dictonnary (Key/Value)
    val secretMap = mapOf("Up" to 1, "Down" to 2, "Left" to 3, "Right" to 4)
    println(secretMap)
    println(secretMap["Down"])

    val emptyMap = emptyMap<String, Boolean>()
}