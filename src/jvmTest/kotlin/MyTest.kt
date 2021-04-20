import kotlinx.coroutines.runBlocking
import me.maikv.wrapperInterfaces.ApiWrapper
import kotlin.test.Test

class MyTest {
    @Test
    fun test(): Unit = runBlocking {
        val apiWrapper = ApiWrapper.getInstance("apiKey")
        apiWrapper.certifications.getMovieCertifications()
    }
}