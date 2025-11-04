package es.mobiledev.data.local.article.dbo

// TODO: Add Room annotations when be to implement
data class ArticleDbo(
    val id: Long,
    val title: String,
    val imageUrl: String,
    val newsSite: String,
    val addedAt: String,
)
