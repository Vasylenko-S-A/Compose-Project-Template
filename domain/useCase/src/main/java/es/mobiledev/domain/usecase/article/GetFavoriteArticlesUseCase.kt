package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface GetFavoriteArticlesUseCase {
    suspend operator fun invoke(): Flow<List<ArticleBo>>
}

class GetFavoriteArticlesUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : GetFavoriteArticlesUseCase {
    override suspend fun invoke(): Flow<List<ArticleBo>> = articleGateway.getFavoriteArticles()
}
