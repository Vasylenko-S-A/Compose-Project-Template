package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface GetArticlesUseCase {
    suspend fun invoke(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>>
}

class GetArticlesUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : GetArticlesUseCase {
    override suspend fun invoke(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>> = articleGateway.getArticles(limit = limit, offset = offset)
}
