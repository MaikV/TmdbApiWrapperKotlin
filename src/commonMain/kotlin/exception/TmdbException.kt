package exception

import io.ktor.client.features.*

class TmdbException(val errorResponse: ErrorResponse, override val cause: ResponseException): Exception(cause)