package me.maikv.wrapperInterfaces

import me.maikv.datatransferobjects.MovieCertifications
import me.maikv.datatransferobjects.TvCertifications

interface CertificationsWrapper: BasePath {
    suspend fun getMovieCertifications(): MovieCertifications
    suspend fun getTvCertifications(): TvCertifications
}