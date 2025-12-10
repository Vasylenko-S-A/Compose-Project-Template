package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo

interface RemoveFavoriteArticleUseCase {
    suspend operator fun invoke(
        article: ArticleBo
    )
}

class RemoveFavoriteArticleUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : RemoveFavoriteArticleUseCase {
    override suspend fun invoke(
        article: ArticleBo
    ) = articleGateway.removeFavoriteArticle(article)
}
