package es.mobiledev.domain.model.article

data class AuthorBo(
    val name: String,
    val socials: SocialsBo?,
)

val mockAuthors =
    listOf(
        AuthorBo(
            name = "Author 1",
            socials = mockSocialsBo1,
        ),
        AuthorBo(
            name = "Author 2",
            socials = mockSocialsBo2,
        ),
    )
