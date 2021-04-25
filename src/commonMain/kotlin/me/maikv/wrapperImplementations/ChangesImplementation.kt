package me.maikv.wrapperImplementations

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import me.maikv.datatransferobjects.Changes
import me.maikv.wrapperInterfaces.ChangesWrapper

internal class ChangesImplementation(private val httpClient: HttpClient) : ChangesWrapper {
    override val basePath: String = "/3"

    override suspend fun getMovieChangeList(endDate: String?, startDate: String?, page: Int?): Changes =
        httpClient.get(path = "$basePath/movie/changes") {
            url {
                parameter("end_date", endDate)
                parameter("start_date", startDate)
                parameter("page", page)
            }
        }

    override suspend fun getTvChangeList(endDate: String?, startDate: String?, page: Int?): Changes =
        httpClient.get(path = "$basePath/tv/changes") {
            url {
                parameter("end_date", endDate)
                parameter("start_date", startDate)
                parameter("page", page)
            }
        }

    override suspend fun getPersonChangeList(endDate: String?, startDate: String?, page: Int?): Changes =
        httpClient.get(path = "$basePath/person/changes") {
            url {
                parameter("end_date", endDate)
                parameter("start_date", startDate)
                parameter("page", page)
            }
        }
}