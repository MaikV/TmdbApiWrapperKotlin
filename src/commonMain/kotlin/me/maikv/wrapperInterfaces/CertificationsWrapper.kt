package me.maikv.wrapperInterfaces

import me.maikv.datatransferobjects.MovieCertifications
import me.maikv.datatransferobjects.TvCertifications

interface CertificationsWrapper: BasePath {
    /**
     * @see <a href="https://developers.themoviedb.org/3/certifications/get-movie-certifications">Documentation</a>
     */
    suspend fun getMovieCertifications(): MovieCertifications

    /**
     * @see <a href="https://developers.themoviedb.org/3/certifications/get-tv-certifications">Documentation</a>
     */
    suspend fun getTvCertifications(): TvCertifications
}