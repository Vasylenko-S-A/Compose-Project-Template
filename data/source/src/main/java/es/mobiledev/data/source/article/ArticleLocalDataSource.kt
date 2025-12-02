package es.mobiledev.data.source.article

import es.mobiledev.domain.model.article.ArticleBo

interface ArticleLocalDataSource {
    suspend fun saveFavoriteArticle(article: ArticleBo)

    suspend fun removeFavoriteArticle(article: ArticleBo)

    suspend fun getFavoriteArticles(): List<ArticleBo>

    suspend fun isArticleFavorite(id: Long): Boolean
}
