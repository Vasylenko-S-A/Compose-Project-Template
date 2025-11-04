package es.mobiledev.data.source.article

import es.mobiledev.domain.model.article.ArticleBo

interface ArticleLocalDataSource {
    suspend fun saveFavoriteArticle(article: ArticleBo): Boolean

    suspend fun removeFavoriteArticle(article: ArticleBo): Boolean

    suspend fun getFavoriteArticles(): List<ArticleBo>
}
