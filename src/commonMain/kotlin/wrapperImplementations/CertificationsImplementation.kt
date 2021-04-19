package wrapperImplementations

import io.ktor.client.*
import io.ktor.client.request.*
import wrapperInterfaces.CertificationsWrapper

internal class CertificationsImplementation(private val httpClient: HttpClient): CertificationsWrapper {
    override suspend fun getMovieCertifications(): String = httpClient.get(path = "/3/certification/movie/list")

    override suspend fun getTvCertifications() {
        TODO("Not yet implemented")
    }
}