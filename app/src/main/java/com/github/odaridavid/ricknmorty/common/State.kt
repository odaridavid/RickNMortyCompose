package com.github.odaridavid.ricknmorty.common

sealed class State<out Result> {

    data class Complete<out Result>(
        val data: Result? = null,
        val error: String? = null
    ) : State<Result>()

}
