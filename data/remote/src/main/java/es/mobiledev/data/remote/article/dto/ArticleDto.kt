package es.mobiledev.data.remote.article.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleDto(
    @Json(name = "id")
    val id: Long?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "authors")
    val authors: List<AuthorDto>?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "image_url")
    val imageUrl: String?,
    @Json(name = "news_site")
    val newsSite: String?,
    @Json(name = "summary")
    val summary: String?,
    @Json(name = "published_at")
    val publishedAt: String?,
    @Json(name = "updated_at")
    val updatedAt: String?,
)

// TODO: Remove when real service is available
val mockArticle1 =
    ArticleDto(
        id = 1,
        title = "Exploring the Cosmos: A Journey to the Stars",
        authors =
            listOf(
                AuthorDto(
                    name = "Dr. Evelyn Reed",
                    socials =
                        SocialsDto(
                            youtube = "youtube.com/channel/EvelynReed",
                            x = "x.com/EvelynReed",
                            mastodon = "mastodon.com/@EvelynReed",
                            bluesky = "bluesky.com/EvelynReed",
                            instagram = "instagram.com/EvelynReed",
                            linkedin = "linkedin.com/in/EvelynReed"
                        )
                )
            ),
        url = "https://example.com/article1",
        imageUrl = "https://www.esa.int/var/esa/storage/images/esa_multimedia/images/2025/10/training_in_the_luna_facilities/26942351-1-eng-GB/Training_in_the_LUNA_facilities_card_full.jpg",
        newsSite = "Cosmic Chronicles",
        summary = "A fascinating exploration of recent astronomical discoveries and the future of space travel.",
        publishedAt = "2024-05-20T10:00:00Z",
        updatedAt = "2024-05-20T12:30:00Z"
    )

val mockArticle2 =
    ArticleDto(
        id = 2,
        title = "The Art of Mindful Living",
        authors =
            listOf(
                AuthorDto(
                    name = "Samuel Green",
                    socials =
                        SocialsDto(
                            youtube = null,
                            x = "x.com/SamuelGreen",
                            mastodon = null,
                            bluesky = "bluesky.com/SamuelGreen",
                            instagram = "instagram.com/SamuelGreen",
                            linkedin = null
                        )
                )
            ),
        url = "https://example.com/article2",
        imageUrl = "https://i0.wp.com/spacenews.com/wp-content/uploads/2025/07/tianlong3-mockup-dongfeng-JSLC-july2025-SpacePioneer.jpg?fit=1024%2C573&ssl=1",
        newsSite = "Wellness Today",
        summary = "Practical tips and insights on how to live a more present and fulfilling life.",
        publishedAt = "2024-05-19T15:00:00Z",
        updatedAt = "2024-05-20T09:00:00Z"
    )

val mockArticle3 =
    ArticleDto(
        id = 3,
        title = "The Future of Artificial Intelligence",
        authors =
            listOf(
                AuthorDto(
                    name = "AI Insights Inc.",
                    socials =
                        SocialsDto(
                            youtube = null,
                            x = null,
                            mastodon = null,
                            bluesky = null,
                            instagram = null,
                            linkedin = null
                        )
                )
            ),
        url = "https://example.com/article3",
        imageUrl = null,
        newsSite = "Tech Forward",
        summary = "An overview of the current state of AI and what to expect in the coming years.",
        publishedAt = "2024-05-18T08:00:00Z",
        updatedAt = "2024-05-18T08:00:00Z"
    )
