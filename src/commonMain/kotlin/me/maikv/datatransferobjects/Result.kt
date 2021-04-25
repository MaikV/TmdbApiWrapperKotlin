package me.maikv.datatransferobjects

import kotlinx.serialization.Serializable

@Serializable
data class Result(
    val adult: Boolean?,
    val id: Int
)