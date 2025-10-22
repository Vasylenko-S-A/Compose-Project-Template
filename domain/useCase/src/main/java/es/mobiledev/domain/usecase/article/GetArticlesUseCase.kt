package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.model.article.mockListArticles
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface GetArticlesUseCase {
    suspend operator fun invoke(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>>
}

// TODO: Pending implementation of the RepositoryModule to use ArticleGateway

/*class GetArticlesUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : GetArticlesUseCase {
    override suspend fun invoke(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>> = articleGateway.getArticles(limit = limit, offset = offset)
}*/

class GetArticlesUseCaseImpl : GetArticlesUseCase {
    override suspend fun invoke(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>> = flowOf(mockListArticles)
}
