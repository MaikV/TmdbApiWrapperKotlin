package me.maikv.datatransferobjects

import kotlinx.serialization.Serializable


@Serializable
data class MovieCertifications(
    val certifications: MovieCertificationValues
)