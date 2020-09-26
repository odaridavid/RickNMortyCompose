package com.github.odaridavid.ricknmorty.common

sealed class State<out Result> {

    data class Success<out Result>(val data: Result?) : State<Result>()

    data class Error<out Result>(val throwable: Throwable?) : State<Result>()

    object Loading : State<Nothing>()

    fun asError(): State<Result> = this as Error<Result>

    fun asSuccess(): State<Result> = this as Success<Result>

    fun isLoading(): Boolean = this is Loading
}
