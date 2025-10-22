package es.mobiledev.data.source.article

import es.mobiledev.domain.model.article.ArticleBo

interface ArticleRemoteDataSource {
    suspend fun getArticles(
        limit: Long,
        offset: Long
    ): List<ArticleBo>
}
