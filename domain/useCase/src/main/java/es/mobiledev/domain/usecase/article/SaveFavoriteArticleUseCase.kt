package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow

interface SaveFavoriteArticleUseCase {
    suspend operator fun invoke(
        article: ArticleBo
    ): Flow<Boolean>
}

class SaveFavoriteArticleUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : SaveFavoriteArticleUseCase {
    override suspend fun invoke(
        article: ArticleBo
    ): Flow<Boolean> = articleGateway.saveFavoriteArticle(article)
}
