package me.maikv.wrapperInterfaces

import me.maikv.wrapperImplementations.ApiImplementation

interface ApiWrapper {
    companion object {
        fun getInstance(apiKey: String): ApiWrapper = ApiImplementation(apiKey)
    }
    val changes: ChangesWrapper
    val certifications: CertificationsWrapper
}

