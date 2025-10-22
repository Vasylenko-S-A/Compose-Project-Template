package es.mobiledev.domain.gateway.article

import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface ArticleGateway {
    suspend fun getArticles(
        limit: Long,
        offset: Long,
    ): Flow<List<ArticleBo>>
}
