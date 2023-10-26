package ca.qc.cstj.jetbizcard.data.repositories

import ca.qc.cstj.jetbizcard.core.ApiResult
import ca.qc.cstj.jetbizcard.core.Constants
import ca.qc.cstj.jetbizcard.data.datasources.ProfileDataSource
import ca.qc.cstj.jetbizcard.models.Profile
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class ProfileRepository {

    private val profileDataSource = ProfileDataSource()

    fun retrieveOne(): Flow<ApiResult<Profile>> {
        return flow {
            while(true) {
                //delay(10000L)
                try{
                    emit(ApiResult.Loading)
                    val profile = profileDataSource.retrieveOne()
                    emit(ApiResult.Success(profile))
                } catch (ex: Exception) {
                    emit(ApiResult.Error(ex))
                }
                delay(Constants.RefreshDelay.PROFILE_REFRESH_DELAY)
            }
        }.flowOn(Dispatchers.IO)
    }

}