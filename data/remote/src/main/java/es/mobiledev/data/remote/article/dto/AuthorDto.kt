package es.mobiledev.data.remote.article.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AuthorDto(
    @Json(name = "name")
    val name: String?,
    @Json(name = "socials")
    val socials: SocialsDto?
)
