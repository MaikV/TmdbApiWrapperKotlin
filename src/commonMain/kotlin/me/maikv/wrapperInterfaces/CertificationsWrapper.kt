package me.maikv.wrapperInterfaces

interface CertificationsWrapper {
    suspend fun getMovieCertifications(): String
    suspend fun getTvCertifications()
}