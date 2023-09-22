package tech.ericwathome.cleanarchprac.feature_posts.data.datasource.remote.dto

data class PostDto(
    val body: String,
    val id: Int,
    val reactions: Int,
    val tags: List<String>,
    val title: String,
    val userId: Int
)