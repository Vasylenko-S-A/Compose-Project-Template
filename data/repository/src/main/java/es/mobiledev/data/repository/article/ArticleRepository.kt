package es.mobiledev.data.repository.article

import es.mobiledev.data.source.article.ArticleRemoteDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepository(
    private val remote: ArticleRemoteDataSource,
) : ArticleGateway {
    // TODO: Change to BO when domain module is ready
    override suspend fun getArticles(
        limit: Long,
        offset: Long
    ): Flow<List<Any>> = flowOf(remote.getArticles(limit = limit, offset = offset))
}

// TODO: Remove when domain module is ready
interface ArticleGateway {
    suspend fun getArticles(
        limit: Long,
        offset: Long
    ): Flow<List<Any>>
}
