package tech.ericwathome.cleanarchprac.feature_posts.presentation.posts_screen

sealed class PostsEvent {
    object OnClickAddPost : PostsEvent()
    data class OnClickPost(val postId: Int) : PostsEvent()
}
