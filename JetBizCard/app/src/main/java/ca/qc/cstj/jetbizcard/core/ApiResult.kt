package ca.qc.cstj.jetbizcard.core

sealed class ApiResult<out R> {
    data class Success<out R>(val data: R) : ApiResult<R>()
    data class Error(val throwable: Throwable):ApiResult<Nothing>()
    object Loading: ApiResult<Nothing>()
}