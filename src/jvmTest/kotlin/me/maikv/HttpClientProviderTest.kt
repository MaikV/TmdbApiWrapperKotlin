package me.maikv

import io.ktor.client.request.HttpRequestPipeline
import io.ktor.client.request.request
import io.ktor.util.pipeline.PipelinePhase
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlinx.coroutines.runBlocking

class HttpClientProviderTest {

    @Test
    fun createHttpClient() = runBlocking {
        // GIVEN
        val apiKey = "apiKey"
        var host = ""
        var apiKeyParameterKey = ""
        var apiKeyParameterValue = ""
        var path = ""

        val client = HttpClientProvider.createHttpClient(apiKey)
        val testPipelinePhase = PipelinePhase("Test")
        client.requestPipeline.insertPhaseBefore(HttpRequestPipeline.Send, testPipelinePhase)
        client.requestPipeline.intercept(testPipelinePhase) {
            host = context.url.host
            val apiKeyParameter = context.url.parameters.entries().single()
            apiKeyParameterKey = apiKeyParameter.key
            apiKeyParameterValue = apiKeyParameter.value.single()
            path = context.url.encodedPath
            // Finish the pipeline before actually sending the request
            finish()
        }

        // WHEN
        val didCatchException = try {
            client.request<Unit> {}
            false
        } catch (expected: ClassCastException) {
            true
        }

        // THEN
        val expectedHost = "api.themoviedb.org"
        val expectedApiKeyParameterKey = "api_key"
        val expectedPath = "/"

        assertTrue(didCatchException)
        assertEquals(expectedPath, path)
        assertEquals(expectedHost, host)
        assertEquals(expectedApiKeyParameterKey, apiKeyParameterKey)
        assertEquals(apiKey, apiKeyParameterValue)
    }
}
