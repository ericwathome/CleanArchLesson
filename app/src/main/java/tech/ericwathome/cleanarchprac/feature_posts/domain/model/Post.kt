package tech.ericwathome.cleanarchprac.feature_posts.domain.model

data class Post(
    val body: String,
    val id: Int,
    val reactions: Int,
    val tags: List<String>,
    val title: String,
    val userId: Int
)
