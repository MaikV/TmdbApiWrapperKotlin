package me.maikv.wrapperImplementations

import io.ktor.client.engine.mock.respond
import io.ktor.client.engine.mock.respondBadRequest
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.http.HttpMethod
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.decodeFromString
import me.maikv.datatransferobjects.Changes
import me.maikv.shared.createTestHttpClient
import me.maikv.shared.defaultContentTypeHeader


internal class ChangesImplementationTest {

    @Test
    fun getBasePath() {
        // GIVEN
        val changesImplementation = ChangesImplementation(createTestHttpClient({
            respondBadRequest()
        }))

        // WHEN
        val basePath = changesImplementation.basePath

        // THEN
        val expectedBasePath = "/3"
        assertEquals(expectedBasePath, basePath)
    }

    @Test
    fun getMovieChangeList() = runBlocking {
        // GIVEN
        @Suppress("MaxLineLength")
        val movieChangeListJsonString = "{\"results\":[{\"id\":313648,\"adult\":false},{\"id\":50704,\"adult\":false},{\"id\":360058,\"adult\":false},{\"id\":407449,\"adult\":false}],\"page\":1,\"total_pages\":1,\"total_results\":1}"
        var path = ""
        var method: HttpMethod? = null

        var startDate: String? = null
        var endDate: String? = null
        var page: Int? = null
        val changes = KotlinxSerializer.DefaultJson.decodeFromString<Changes>(movieChangeListJsonString)
        val testClient = createTestHttpClient({ httpRequestData ->
            path = httpRequestData.url.encodedPath
            startDate = httpRequestData.url.parameters["start_date"]
            endDate = httpRequestData.url.parameters["end_date"]
            page = httpRequestData.url.parameters["page"]?.toIntOrNull()
            method = httpRequestData.method
            respond(
                movieChangeListJsonString,
                headers = defaultContentTypeHeader()
            )
        })
        val expectedStartDate = "startdate"
        val expectedEndDate = "enddate"
        val expectedPage = 34
        val changesImplementation = ChangesImplementation(testClient)

        // WHEN
        val result = changesImplementation.getMovieChangeList(
            endDate = expectedEndDate,
            startDate = expectedStartDate,
            page = expectedPage
        )

        // THEN
        assertEquals(changes, result)
        assertEquals(HttpMethod.Get, method)
        assertEquals("/3/movie/changes", path)
        assertEquals(expectedStartDate, startDate)
        assertEquals(expectedEndDate, endDate)
        assertEquals(expectedPage, page)
    }

    @Test
    fun getTvChangeList() = runBlocking {
        // GIVEN
        @Suppress("MaxLineLength")
        val tvChangesListJsonString = "{\"results\": [{\"id\": 75219,\"adult\": false},{\"id\": 39290,\"adult\": false},{\"id\": 61930,\"adult\": false},{\"id\": 123543,\"adult\": false}],\"page\": 1,\"total_pages\": 1,\"total_results\": 1}"
        var path = ""
        var method: HttpMethod? = null

        var startDate: String? = null
        var endDate: String? = null
        var page: Int? = null
        val changes = KotlinxSerializer.DefaultJson.decodeFromString<Changes>(tvChangesListJsonString)
        val testClient = createTestHttpClient({ httpRequestData ->
            path = httpRequestData.url.encodedPath
            startDate = httpRequestData.url.parameters["start_date"]
            endDate = httpRequestData.url.parameters["end_date"]
            page = httpRequestData.url.parameters["page"]?.toIntOrNull()
            method = httpRequestData.method
            respond(
                tvChangesListJsonString,
                headers = defaultContentTypeHeader()
            )
        })
        val changesImplementation = ChangesImplementation(testClient)
        val expectedStartDate = "startdate"
        val expectedEndDate = "enddate"
        val expectedPage = 34

        // WHEN
        val result = changesImplementation.getTvChangeList(
            endDate = expectedEndDate,
            startDate = expectedStartDate,
            page = expectedPage
        )

        // THEN
        assertEquals(changes, result)
        assertEquals(HttpMethod.Get, method)
        assertEquals("/3/tv/changes", path)
        assertEquals(expectedStartDate, startDate)
        assertEquals(expectedEndDate, endDate)
        assertEquals(expectedPage, page)
    }

    @Test
    fun getPersonChangeList() = runBlocking {
        // GIVEN
        @Suppress("MaxLineLength")
        val personChangesListJsonString = "{\"results\": [{\"id\": 75219,\"adult\": false},{\"id\": 39290,\"adult\": false},{\"id\": 61930,\"adult\": false},{\"id\": 123543,\"adult\": false}],\"page\": 1,\"total_pages\": 1,\"total_results\": 1}"
        var path = ""
        var method: HttpMethod? = null

        var startDate: String? = null
        var endDate: String? = null
        var page: Int? = null
        val changes = KotlinxSerializer.DefaultJson.decodeFromString<Changes>(personChangesListJsonString)
        val testClient = createTestHttpClient({ httpRequestData ->
            path = httpRequestData.url.encodedPath
            startDate = httpRequestData.url.parameters["start_date"]
            endDate = httpRequestData.url.parameters["end_date"]
            page = httpRequestData.url.parameters["page"]?.toIntOrNull()
            method = httpRequestData.method
            respond(
                personChangesListJsonString,
                headers = defaultContentTypeHeader()
            )
        })
        val changesImplementation = ChangesImplementation(testClient)
        val expectedStartDate = "startdate"
        val expectedEndDate = "enddate"
        val expectedPage = 34

        // WHEN
        val result = changesImplementation.getPersonChangeList(
            endDate = expectedEndDate,
            startDate = expectedStartDate,
            page = expectedPage
        )

        // THEN
        assertEquals(changes, result)
        assertEquals(HttpMethod.Get, method)
        assertEquals("/3/person/changes", path)
        assertEquals(expectedStartDate, startDate)
        assertEquals(expectedEndDate, endDate)
        assertEquals(expectedPage, page)
    }
}



