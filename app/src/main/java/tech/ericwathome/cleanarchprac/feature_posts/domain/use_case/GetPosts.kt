package tech.ericwathome.cleanarchprac.feature_posts.domain.use_case

import kotlinx.coroutines.flow.Flow
import tech.ericwathome.cleanarchprac.feature_posts.core.util.Resource
import tech.ericwathome.cleanarchprac.feature_posts.domain.model.Post
import tech.ericwathome.cleanarchprac.feature_posts.domain.repository.PostsRepository
import javax.inject.Inject

class GetPosts @Inject constructor(
    private val repository: PostsRepository
) {

    suspend operator fun invoke(): Flow<Resource<List<Post>>> {
        return repository.getPosts()
    }

}