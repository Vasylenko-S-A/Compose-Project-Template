package es.mobiledev.domain.model.article

data class SocialsBo(
    val youtube: String,
    val x: String,
    val mastodon: String,
    val bluesky: String,
    val instagram: String,
    val linkedin: String,
)

val mockSocialsBo1 =
    SocialsBo(
        youtube = "youtube.com/author2",
        x = "x.com/author2",
        mastodon = "mastodon.social/@author2",
        bluesky = "author2.bsky.social",
        instagram = "instagram.com/author2",
        linkedin = "linkedin.com/in/author2",
    )

val mockSocialsBo2 =
    SocialsBo(
        youtube = "youtube.com/author2",
        x = "x.com/author2",
        mastodon = "mastodon.social/@author2",
        bluesky = "author2.bsky.social",
        instagram = "instagram.com/author2",
        linkedin = "linkedin.com/in/author2"
    )
