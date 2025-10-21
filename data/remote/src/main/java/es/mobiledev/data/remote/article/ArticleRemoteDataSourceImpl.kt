package es.mobiledev.data.remote.article

import es.mobiledev.data.remote.article.dto.mockArticle1
import es.mobiledev.data.remote.article.dto.mockArticle2
import es.mobiledev.data.remote.article.dto.mockArticle3
import es.mobiledev.data.source.article.ArticleRemoteDataSource

class ArticleRemoteDataSourceImpl(
    articleWs: ArticleWs
) : ArticleRemoteDataSource {
    // TODO: Change dto for bo and implement real service
    override suspend fun getArticles(
        limit: Long,
        offset: Long
    ): List<Any> =
        // articleWs.getArticles(limit, offset).map {it.toBo()}
        listOf(mockArticle1, mockArticle2, mockArticle3)
}
