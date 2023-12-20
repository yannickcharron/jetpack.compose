package ca.qc.cstj.navigationdemo.models

import kotlinx.serialization.Serializable

@Serializable
data class Profile(
    val name: String,
    val title: String,
    val alias:String,
    val projects: List<Project>
)