package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface GetArticleByIdUseCase {
    suspend operator fun invoke(
        id: Long,
    ): Flow<ArticleBo>
}

class GetArticleByIdUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : GetArticleByIdUseCase {
    override suspend fun invoke(
        id: Long,
    ): Flow<ArticleBo> = articleGateway.getArticleById(id = id)
}
