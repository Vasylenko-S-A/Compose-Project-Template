package es.mobiledev.data.source.article

import es.mobiledev.domain.model.article.ArticleBo
import es.mobiledev.domain.model.article.ArticleResponseBo

interface ArticleRemoteDataSource {
    suspend fun getArticles(
        limit: Long,
        offset: Long
    ): ArticleResponseBo

    suspend fun getArticleById(
        id: Long
    ): ArticleBo
}
