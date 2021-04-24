package me.maikv.shared

import io.ktor.client.HttpClient
import io.ktor.client.engine.mock.MockEngine
import io.ktor.client.engine.mock.MockRequestHandleScope
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.HttpRequestData
import io.ktor.client.request.HttpResponseData
import io.ktor.http.ContentType
import io.ktor.http.headersOf

fun createTestHttpClient(vararg handler: suspend MockRequestHandleScope.(HttpRequestData) -> HttpResponseData) =
    HttpClient(MockEngine) {
        engine {
            handler.forEach {
                addHandler(it)
            }
        }
        install(JsonFeature) {
            serializer = KotlinxSerializer()
        }
    }

fun defaultContentTypeHeader() = headersOf("Content-Type", ContentType.Application.Json.toString())
