package es.mobiledev.data.local.article.datasource

import es.mobiledev.data.local.article.dao.toBo
import es.mobiledev.data.local.article.dao.toDbo
import es.mobiledev.data.local.article.dbo.ArticleDbo
import es.mobiledev.data.source.article.ArticleLocalDataSource
import es.mobiledev.domain.model.article.ArticleBo

// TODO: Connect with Dao when implement Room
class ArticleLocalDataSourceImpl(
    // private val articleDao: ArticleDao
) : ArticleLocalDataSource {
    val mockLocalDb = mutableListOf<ArticleDbo>()

    override suspend fun saveFavoriteArticle(article: ArticleBo) =
        // articleDao.saveFavoriteArticle(article.toDbo())
        mockLocalDb.add(article.toDbo())

    override suspend fun removeFavoriteArticle(article: ArticleBo) =
        // articleDao.removeFavoriteArticle(article.toDbo())
        mockLocalDb.remove(article.toDbo())

    override suspend fun getFavoriteArticles(): List<ArticleBo> =
        // articleDao.getFavoriteArticles().map { it.toBo() }
        mockLocalDb.map { it.toBo() }
}
