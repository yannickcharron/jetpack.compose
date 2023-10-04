package ca.qc.cstj.jetbizcard.core

object Constants {
    private const val BASE_API = "http://10.0.2.2:3003"

    const val PROFILE_URL = "$BASE_API/profile"

    object RefreshDelay {
        const val PROFILE_REFRESH_DELAY = 65000L
    }

}