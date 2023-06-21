package ca.qc.cstj.kotlinplayground

fun main() {
    val input = Result.ERROR
    getResult(input)
}

fun getResult(result: Result) {
    return when(result) {
        Result.SUCCESS -> println("Success")
        Result.FAILURE -> println("Failure")
        Result.ERROR -> println("Error")
    }
}

object Repository {

}

enum class Result {
    SUCCESS,
    FAILURE,
    ERROR
}