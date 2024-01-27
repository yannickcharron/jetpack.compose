package ca.qc.cstj.pizzaorder.ui.navigation

sealed class Screens(val route:String, val title: String) {
    data object Start: Screens("start", "Pizza Planet")
}