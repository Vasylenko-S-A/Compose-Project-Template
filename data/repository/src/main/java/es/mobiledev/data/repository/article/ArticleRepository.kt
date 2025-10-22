package es.mobiledev.data.repository.article

import es.mobiledev.data.source.article.ArticleRemoteDataSource
import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepository(
    private val remote: ArticleRemoteDataSource,
) : ArticleGateway {
    override suspend fun getArticles(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>> = flowOf(remote.getArticles(limit = limit, offset = offset))
}
