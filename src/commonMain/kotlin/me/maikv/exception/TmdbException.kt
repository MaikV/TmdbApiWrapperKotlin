package me.maikv.exception

import io.ktor.client.features.ResponseException

class TmdbException(val errorResponse: ErrorResponse, override val cause: ResponseException) : Exception(cause)