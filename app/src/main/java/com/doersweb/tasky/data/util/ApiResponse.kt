package com.doersweb.tasky.data.util

sealed class ApiResponse<out T> {
    data class Success<out T>(val data: T) : ApiResponse<T>()
    data class Error(val errorType: ErrorType): ApiResponse<Nothing>()
}

sealed class ErrorType{
    object GeneralException: ErrorType()
    data class GenericMessage(val message: String): ErrorType()
}
