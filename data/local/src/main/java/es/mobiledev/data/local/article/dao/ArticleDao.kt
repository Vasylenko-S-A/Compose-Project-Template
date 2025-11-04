package es.mobiledev.data.local.article.dao

import es.mobiledev.data.local.article.dbo.ArticleDbo

// TODO: Add Room annotations when be to implement
interface ArticleDao {
    suspend fun saveFavoriteArticle(article: ArticleDbo)

    suspend fun removeFavoriteArticle(article: ArticleDbo)

    suspend fun getFavoriteArticles(): List<ArticleDbo>
}
