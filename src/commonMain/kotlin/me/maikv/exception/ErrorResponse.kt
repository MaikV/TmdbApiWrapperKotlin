package me.maikv.exception

import kotlinx.serialization.Serializable
import kotlinx.serialization.SerialName

@Serializable
data class ErrorResponse(
    @SerialName("status_code")
    val statusCode: Int,
    @SerialName("status_message")
    val statusMessage: String,
    @SerialName("success")
    val success: Boolean
)