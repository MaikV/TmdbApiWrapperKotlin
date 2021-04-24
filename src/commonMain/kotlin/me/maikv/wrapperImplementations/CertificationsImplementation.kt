package me.maikv.wrapperImplementations

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import me.maikv.datatransferobjects.MovieCertifications
import me.maikv.datatransferobjects.TvCertifications
import me.maikv.wrapperInterfaces.CertificationsWrapper

internal class CertificationsImplementation(private val httpClient: HttpClient) : CertificationsWrapper {
    override val basePath: String = "/3/certification"

    override suspend fun getMovieCertifications(): MovieCertifications = httpClient.get(path = "$basePath/movie/list")

    override suspend fun getTvCertifications(): TvCertifications = httpClient.get(path = "$basePath/tv/list")
}
