package tech.ericwathome.cleanarchprac.feature_posts.data.datasource.remote

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import tech.ericwathome.cleanarchprac.feature_posts.data.datasource.remote.dto.PostDto

interface PostsApiService {

    @GET("posts")
    suspend fun getPosts(): List<PostDto>

    @GET("posts/{id}")
    suspend fun getPost(@Path("id") id: Int): PostDto

    @POST("posts/add")
    suspend fun addPost(@Body postDto: PostDto): PostDto

}