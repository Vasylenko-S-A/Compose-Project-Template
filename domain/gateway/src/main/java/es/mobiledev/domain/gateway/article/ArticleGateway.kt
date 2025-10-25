package es.mobiledev.domain.gateway.article

import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface ArticleGateway {
    suspend fun getArticles(
        limit: Long,
        offset: Long,
    ): Flow<List<ArticleBo>>

    suspend fun getFavoriteArticles(): Flow<List<ArticleBo>>

    suspend fun saveFavoriteArticle(articleBo: ArticleBo)

    suspend fun removeFavoriteArticle(articleBo: ArticleBo)
}
