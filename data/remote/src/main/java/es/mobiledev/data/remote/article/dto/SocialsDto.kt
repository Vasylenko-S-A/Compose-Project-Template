package es.mobiledev.data.remote.article.dto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SocialsDto(
    @Json(name = "youtube")
    val youtube: String?,
    @Json(name = "x")
    val x: String?,
    @Json(name = "mastodon")
    val mastodon: String?,
    @Json(name = "bluesky")
    val bluesky: String?,
    @Json(name = "instagram")
    val instagram: String?,
    @Json(name = "linkedin")
    val linkedin: String?
)
