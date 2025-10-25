package es.mobiledev.data.local.article.dao

import es.mobiledev.data.local.article.dbo.ArticleDbo
import es.mobiledev.domain.model.article.ArticleBo
import java.time.Instant

fun ArticleDbo.toBo() =
    ArticleBo(
        id = id,
        title = title,
        newsSite = newsSite,
        imageUrl = imageUrl,
        authors = emptyList(),
        url = "",
        summary = "",
        publishedAt = "",
        updatedAt = "",
    )

fun ArticleBo.toDbo() =
    ArticleDbo(
        id = id,
        title = title,
        newsSite = newsSite,
        imageUrl = imageUrl,
        addedAt = Instant.now().toString()
    )
