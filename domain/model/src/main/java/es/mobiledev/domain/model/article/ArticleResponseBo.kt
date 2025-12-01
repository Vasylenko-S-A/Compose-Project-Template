package es.mobiledev.domain.model.article

data class ArticleResponseBo(
    val count: Long,
    val next: String,
    val previous: String,
    val results: List<ArticleBo>
)
