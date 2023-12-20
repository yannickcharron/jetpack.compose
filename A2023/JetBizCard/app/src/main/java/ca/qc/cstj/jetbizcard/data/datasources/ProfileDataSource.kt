package ca.qc.cstj.jetbizcard.data.datasources

import ca.qc.cstj.jetbizcard.core.Constants
import ca.qc.cstj.jetbizcard.models.Profile
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.fuel.json.responseJson
import com.github.kittinunf.result.Result
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class ProfileDataSource {

    private val json = Json { ignoreUnknownKeys = true }

    fun retrieveOne() : Profile {
        val (_, _, result) = Constants.PROFILE_URL.httpGet().responseJson()

        when(result) {
            is Result.Success -> return json.decodeFromString(result.value.content)
            is Result.Failure -> throw result.error.exception
        }
    }
}