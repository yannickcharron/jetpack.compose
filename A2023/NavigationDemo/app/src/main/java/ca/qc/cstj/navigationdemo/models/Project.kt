package ca.qc.cstj.navigationdemo.models

import ca.qc.cstj.navigationdemo.core.serializers.DateSerializer
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class Project(
    val title: String,
    val image: String,

    @Serializable(with = DateSerializer::class)
    val datetime: Date
)