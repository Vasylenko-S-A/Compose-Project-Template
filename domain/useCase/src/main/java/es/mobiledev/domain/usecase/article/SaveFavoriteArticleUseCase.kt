package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo

interface SaveFavoriteArticleUseCase {
    suspend operator fun invoke(
        article: ArticleBo
    )
}

class SaveFavoriteArticleUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : SaveFavoriteArticleUseCase {
    override suspend fun invoke(
        article: ArticleBo
    ) = articleGateway.saveFavoriteArticle(article)
}
