package me.maikv

import io.ktor.client.HttpClient
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.HttpCallValidator
import io.ktor.client.features.ResponseException
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.DEFAULT
import io.ktor.client.features.logging.LogLevel
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.statement.readText
import io.ktor.http.URLProtocol
import kotlinx.serialization.decodeFromString
import me.maikv.exception.ErrorResponse
import me.maikv.exception.TmdbException

internal object HttpClientProvider {
    fun createHttpClient(apiKey: String): HttpClient = HttpClient {
        install(DefaultRequest) {
            url {
                protocol = URLProtocol.HTTPS
                host = "api.themoviedb.org"
                parameters.append("api_key", apiKey)
            }
        }
        install(HttpCallValidator) {
            handleResponseException { throwable ->
                if (throwable is ResponseException) {
                    // TODO: Should probably use a better defined Json instance
                    val errorResponse =
                        KotlinxSerializer.DefaultJson.decodeFromString<ErrorResponse>(throwable.response.readText())
                    throw TmdbException(errorResponse, throwable)
                }
            }
            validateResponse {
                println("validateResponse $it")
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.BODY
        }
    }
}
