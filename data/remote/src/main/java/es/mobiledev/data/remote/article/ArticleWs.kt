package es.mobiledev.data.remote.article

import es.mobiledev.data.remote.article.dto.ArticleDto
import es.mobiledev.data.remote.article.dto.ArticleResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleWs {
    @GET("articles")
    suspend fun getArticles(
        @Query("limit") limit: Long,
        @Query("offset") offset: Long
    ): ArticleResponseDto

    @GET("articles/{id}/")
    suspend fun getArticleById(
        @Path("id") id: Long
    ): ArticleDto
}
