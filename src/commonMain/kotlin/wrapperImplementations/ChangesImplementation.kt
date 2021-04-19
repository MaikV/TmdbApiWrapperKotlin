package wrapperImplementations

import io.ktor.client.*
import wrapperInterfaces.ChangesWrapper

internal class ChangesImplementation(private val httpClient: HttpClient): ChangesWrapper {
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