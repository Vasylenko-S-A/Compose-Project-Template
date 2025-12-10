package es.mobiledev.data.local.article.dbo

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")
data class ArticleDbo(
    @PrimaryKey val id: Long,
    val title: String,
    val imageUrl: String,
    val newsSite: String,
    val addedAt: String,
)
