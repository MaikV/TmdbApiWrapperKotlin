package me.maikv.datatransferobjects

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Certification(
    @SerialName("certification")
    val certification: String,
    @SerialName("meaning")
    val meaning: String,
    @SerialName("order")
    val order: Int
)