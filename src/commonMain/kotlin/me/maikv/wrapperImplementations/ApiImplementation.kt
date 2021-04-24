package me.maikv.wrapperImplementations

import io.ktor.client.HttpClient
import me.maikv.HttpClientProvider
import me.maikv.wrapperInterfaces.ApiWrapper
import me.maikv.wrapperInterfaces.CertificationsWrapper
import me.maikv.wrapperInterfaces.ChangesWrapper

internal class ApiImplementation(apiKey: String) : ApiWrapper {
    private val httpClient: HttpClient = HttpClientProvider.createHttpClient(apiKey)

    override val changes: ChangesWrapper = ChangesImplementation(httpClient)
    override val certifications: CertificationsWrapper = CertificationsImplementation(httpClient)
}