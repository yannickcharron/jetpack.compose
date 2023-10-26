package ca.qc.cstj.jetbizcard.models

import ca.qc.cstj.jetbizcard.core.serializers.DateSerializer
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Project(
    val title: String,
    val image: String,

    @Serializable(with = DateSerializer::class)
    val datetime:Date
)
