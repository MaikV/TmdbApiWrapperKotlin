package wrapperImplementations

import createHttpClient
import io.ktor.client.*
import wrapperInterfaces.ApiWrapper
import wrapperInterfaces.CertificationsWrapper
import wrapperInterfaces.ChangesWrapper

internal class ApiImplementation(apiKey: String): ApiWrapper {
    private val httpClient: HttpClient = createHttpClient(apiKey)

    override val changes: ChangesWrapper = ChangesImplementation(httpClient)
    override val certifications: CertificationsWrapper = CertificationsImplementation(httpClient)
}