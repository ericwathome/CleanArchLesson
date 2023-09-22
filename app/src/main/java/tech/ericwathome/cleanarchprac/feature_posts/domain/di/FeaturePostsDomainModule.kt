package tech.ericwathome.cleanarchprac.feature_posts.domain.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import tech.ericwathome.cleanarchprac.feature_posts.domain.repository.PostsRepository
import tech.ericwathome.cleanarchprac.feature_posts.domain.use_case.AddPost
import tech.ericwathome.cleanarchprac.feature_posts.domain.use_case.GetPost
import tech.ericwathome.cleanarchprac.feature_posts.domain.use_case.GetPosts
import tech.ericwathome.cleanarchprac.feature_posts.domain.use_case.PostsUseCases

@Module
@InstallIn(ViewModelComponent::class)
object FeaturePostsDomainModule {

    @Provides
    @ViewModelScoped
    fun provideAddPost(repository: PostsRepository): AddPost {
        return AddPost(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPost(repository: PostsRepository): GetPost {
        return GetPost(repository)
    }

    @Provides
    @ViewModelScoped
    fun provideGetPosts(repository: PostsRepository): GetPosts {
        return GetPosts(repository)
    }

    @Provides
    @ViewModelScoped
    fun providePostsUseCases(
        addPost: AddPost,
        getPost: GetPost,
        getPosts: GetPosts
    ): PostsUseCases {
        return PostsUseCases(
            addPost = addPost,
            getPost = getPost,
            getPosts = getPosts
        )
    }
}