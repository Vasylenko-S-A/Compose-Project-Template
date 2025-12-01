package es.mobiledev.data.remote.article.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleResponseDto(
    @Json(name = "count")
    val count: Long?,
    @Json(name = "next")
    val next: String?,
    @Json(name = "previous")
    val previous: String?,
    @Json(name = "results")
    val results: List<ArticleDto>?
)
