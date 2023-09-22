package tech.ericwathome.cleanarchprac.feature_posts.domain.use_case

data class PostsUseCases(
    val addPost: AddPost,
    val getPosts: GetPosts,
    val getPost: GetPost
)
