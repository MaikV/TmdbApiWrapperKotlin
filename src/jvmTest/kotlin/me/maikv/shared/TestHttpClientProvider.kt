package me.maikv.shared

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*

fun createTestHttpClient(vararg handler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData) =
    HttpClient(MockEngine) {
        engine {
            handler.forEach {
                addHandler(it)
            }
        }
    }