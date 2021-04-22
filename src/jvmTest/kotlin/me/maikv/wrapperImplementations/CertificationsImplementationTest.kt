package me.maikv.wrapperImplementations

import kotlinx.coroutines.runBlocking
import me.maikv.BuildKonfig
import me.maikv.HttpClientProvider
import kotlin.test.Test

internal class CertificationsImplementationTest {

    // FIXME: Proper test
    @Test
    fun getMovieCertifications() = runBlocking {
        val result = CertificationsImplementation(HttpClientProvider.createHttpClient(BuildKonfig.ApiKey)).getMovieCertifications()
        println(result)
    }

    // FIXME: Proper test
    @Test
    fun getTvCertifications() = runBlocking {
        val result = CertificationsImplementation(HttpClientProvider.createHttpClient(BuildKonfig.ApiKey)).getTvCertifications()
        println(result)
    }
}