package es.mobiledev.navigation

enum class NavigationModule(
    val hasOwnTab: Boolean = false
) {
    LAUNCHER,
    HOME(hasOwnTab = true),
    TEST(hasOwnTab = true),
    ARTICLE_DETAIL
}
