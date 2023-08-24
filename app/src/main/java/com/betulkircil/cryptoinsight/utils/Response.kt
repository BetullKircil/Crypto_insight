package com.betulkircil.cryptoinsight.utils

sealed class Response<out R> {
    object Loading: Response<Nothing>()

    data class Success<out R>(
        val result: R
    ): Response<R>()

    data class Failure(
        val e: Exception
    ): Response<Nothing>()
}