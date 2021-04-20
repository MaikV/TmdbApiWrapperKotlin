package me.maikv.wrapperImplementations

import me.maikv.createHttpClient
import io.ktor.client.*
import me.maikv.wrapperInterfaces.ApiWrapper
import me.maikv.wrapperInterfaces.CertificationsWrapper
import me.maikv.wrapperInterfaces.ChangesWrapper

internal class ApiImplementation(apiKey: String): ApiWrapper {
    private val httpClient: HttpClient = createHttpClient(apiKey)

    override val changes: ChangesWrapper = ChangesImplementation(httpClient)
    override val certifications: CertificationsWrapper = CertificationsImplementation(httpClient)
}