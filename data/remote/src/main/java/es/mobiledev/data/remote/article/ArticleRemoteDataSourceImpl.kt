package es.mobiledev.data.remote.article

import es.mobiledev.data.remote.article.dto.mockArticle1
import es.mobiledev.data.remote.article.dto.mockArticle2
import es.mobiledev.data.remote.article.dto.mockArticle3
import es.mobiledev.data.source.article.ArticleRemoteDataSource
import es.mobiledev.domain.model.article.ArticleBo

class ArticleRemoteDataSourceImpl : ArticleRemoteDataSource {
    // TODO: Change when implement real service
    override suspend fun getArticles(
        limit: Long,
        offset: Long
    ): List<ArticleBo> =
        // articleWs.getArticles(limit, offset).map {it.toBo()}
        listOf(mockArticle1, mockArticle2, mockArticle3).map { it.toBo() }
}
