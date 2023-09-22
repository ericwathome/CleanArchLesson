package tech.ericwathome.cleanarchprac.feature_posts.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import tech.ericwathome.cleanarchprac.feature_posts.data.datasource.remote.PostsApiService
import tech.ericwathome.cleanarchprac.feature_posts.data.mappers.toPost
import tech.ericwathome.cleanarchprac.feature_posts.data.mappers.toPostDto
import tech.ericwathome.cleanarchprac.feature_posts.domain.model.Post
import tech.ericwathome.cleanarchprac.feature_posts.domain.repository.PostsRepository
import tech.ericwathome.cleanarchprac.feature_posts.core.util.DispatcherProvider
import tech.ericwathome.cleanarchprac.feature_posts.core.util.Resource
import tech.ericwathome.cleanarchprac.feature_posts.core.util.safeApiCall
import javax.inject.Inject

class DefaultPostsRepository @Inject constructor(
    private val postsApiService: PostsApiService,
    private val dispatcher: DispatcherProvider
) : PostsRepository {
    override suspend fun getPosts(): Flow<Resource<List<Post>>> {
        return safeApiCall { postsApiService.getPosts().map { it.toPost() } }.flowOn(dispatcher.io)
    }

    override suspend fun getPost(id: Int): Flow<Resource<Post>> {
        return safeApiCall { postsApiService.getPost(id).toPost() }.flowOn(dispatcher.io)
    }

    override suspend fun addPost(post: Post): Flow<Resource<Post>> {
        return safeApiCall {
            postsApiService.addPost(post.toPostDto()).toPost()
        }.flowOn(dispatcher.io)
    }
}