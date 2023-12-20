package ca.qc.cstj.navigationdemo.ui.screens.list

//https://cazimirroman.medium.com/sealed-classes-vs-data-classes-669446e8ed3b
//https://medium.com/swlh/new-way-handle-state-event-in-android-with-sealed-classes-75ad63560574
//https://betterprogramming.pub/how-to-use-kotlin-sealed-classes-for-state-management-c1cfb81abc6a
data class ListUIState(
    val counter:Int = 0,
    var list:List<Int> = listOf()
)
