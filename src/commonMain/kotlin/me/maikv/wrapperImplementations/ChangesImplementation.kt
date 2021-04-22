package me.maikv.wrapperImplementations

import io.ktor.client.*
import me.maikv.wrapperInterfaces.ChangesWrapper

internal class ChangesImplementation(private val httpClient: HttpClient): ChangesWrapper {
    override val basePath: String
        get() = TODO("Not yet implemented")

    override suspend fun getMovieChangeList() {
        TODO("Not yet implemented")
    }

    override suspend fun getTvChangeList() {
        TODO("Not yet implemented")
    }

    override suspend fun getPersonChangeList() {
        TODO("Not yet implemented")
    }
}