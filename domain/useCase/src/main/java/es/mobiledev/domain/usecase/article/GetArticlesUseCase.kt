package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleResponseBo
import kotlinx.coroutines.flow.Flow

interface GetArticlesUseCase {
    suspend operator fun invoke(
        limit: Long,
        offset: Long
    ): Flow<ArticleResponseBo>
}

class GetArticlesUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : GetArticlesUseCase {
    override suspend fun invoke(
        limit: Long,
        offset: Long
    ): Flow<ArticleResponseBo> = articleGateway.getArticles(limit = limit, offset = offset)
}
