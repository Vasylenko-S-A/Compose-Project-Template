package es.mobiledev.domain.usecase.article

import es.mobiledev.domain.gateway.article.ArticleGateway
import kotlinx.coroutines.flow.Flow

interface IsArticleFavoriteUseCase {
    suspend operator fun invoke(
        id: Long,
    ): Flow<Boolean>
}

class IsArticleFavoriteUseCaseImpl(
    private val articleGateway: ArticleGateway,
) : IsArticleFavoriteUseCase {
    override suspend fun invoke(
        id: Long,
    ): Flow<Boolean> = articleGateway.isArticleFavorite(id)
}
