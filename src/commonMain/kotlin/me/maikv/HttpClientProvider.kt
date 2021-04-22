package me.maikv

import me.maikv.exception.ErrorResponse
import me.maikv.exception.TmdbException
import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString

internal object HttpClientProvider {
    fun createHttpClient(apiKey: String): HttpClient = HttpClient {
        install(DefaultRequest) {
            this.url {
                protocol = URLProtocol.HTTPS
                host = "api.themoviedb.org"
                parameters.append("api_key", apiKey)
            }
        }
        install(HttpCallValidator) {
            handleResponseException { throwable ->
                if (throwable is ResponseException) {
                    // FIXME: Should probably use a better defined Json instance
                    val errorResponse =
                        kotlinx.serialization.json.Json { }.decodeFromString<ErrorResponse>(throwable.response.readText())
                    throw TmdbException(errorResponse, throwable)
                }
                println("handleResponseException $throwable")
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
