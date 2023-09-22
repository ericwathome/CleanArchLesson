package tech.ericwathome.cleanarchprac.feature_posts.presentation.posts_screen

import tech.ericwathome.cleanarchprac.feature_posts.domain.model.Post

data class PostsState(
    var posts: List<Post> = emptyList(),
    var loading: Boolean = false,
    var error: Boolean = false,
    var showDialog: Boolean = false,
    var errorMessage: String = ""
)