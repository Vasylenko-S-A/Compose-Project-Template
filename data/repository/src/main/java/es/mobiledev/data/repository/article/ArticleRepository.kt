package es.mobiledev.data.repository.article

import es.mobiledev.data.source.article.ArticleLocalDataSource
import es.mobiledev.data.source.article.ArticleRemoteDataSource
import es.mobiledev.domain.gateway.article.ArticleGateway
import es.mobiledev.domain.model.article.ArticleBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ArticleRepository(
    private val remote: ArticleRemoteDataSource,
    private val local: ArticleLocalDataSource,
) : ArticleGateway {
    override suspend fun getArticles(
        limit: Long,
        offset: Long
    ): Flow<List<ArticleBo>> = flowOf(remote.getArticles(limit = limit, offset = offset))

    override suspend fun getFavoriteArticles(): Flow<List<ArticleBo>> = flowOf(local.getFavoriteArticles())

    override suspend fun saveFavoriteArticle(articleBo: ArticleBo) = flowOf(local.saveFavoriteArticle(articleBo))

    override suspend fun removeFavoriteArticle(articleBo: ArticleBo) = flowOf(local.removeFavoriteArticle(articleBo))
}
