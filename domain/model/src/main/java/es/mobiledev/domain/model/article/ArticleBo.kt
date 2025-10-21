package es.mobiledev.domain.model.article

data class ArticleBo(
    val id: Long,
    val title: String,
    val authors: List<AuthorBo>,
    val url: String,
    val imageUrl: String,
    val newsSite: String,
    val summary: String,
    val publishedAt: String,
    val updatedAt: String,
)
