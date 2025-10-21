package es.mobiledev.data.source.article

interface ArticleRemoteDataSource {
    // TODO CHANGE ANY FOR HIS BO
    suspend fun getArticles(
        limit: Long,
        offset: Long
    ): List<Any>
}
