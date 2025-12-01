package es.mobiledev.domain.gateway.article

import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.model.article.ArticleResponseBo
import kotlinx.coroutines.flow.Flow

interface ArticleGateway {
    suspend fun getArticles(
        limit: Long,
        offset: Long,
    ): Flow<ArticleResponseBo>

    suspend fun getFavoriteArticles(): Flow<List<ArticleBo>>

    suspend fun saveFavoriteArticle(articleBo: ArticleBo)

    suspend fun removeFavoriteArticle(articleBo: ArticleBo)
}
