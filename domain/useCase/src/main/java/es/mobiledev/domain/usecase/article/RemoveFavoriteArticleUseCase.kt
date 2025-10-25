package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface RemoveFavoriteArticleUseCase {
    suspend operator fun invoke(
        article: ArticleBo
    ): Flow<Boolean>
}

class RemoveFavoriteArticleUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : RemoveFavoriteArticleUseCase {
    override suspend fun invoke(
        article: ArticleBo
    ): Flow<Boolean> = articleGateway.removeFavoriteArticle(article)
}
