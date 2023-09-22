package tech.ericwathome.cleanarchprac.feature_posts.domain.repository

import kotlinx.coroutines.flow.Flow
import tech.ericwathome.cleanarchprac.feature_posts.domain.model.Post
import tech.ericwathome.cleanarchprac.feature_posts.core.util.Resource

interface PostsRepository {
    suspend fun getPosts(): Flow<Resource<List<Post>>>
    suspend fun getPost(id: Int): Flow<Resource<Post>>
    suspend fun addPost(post: Post): Flow<Resource<Post>>
}