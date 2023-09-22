package tech.ericwathome.cleanarchprac.feature_posts.data.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.ericwathome.cleanarchprac.feature_posts.data.repository.DefaultPostsRepository
import tech.ericwathome.cleanarchprac.feature_posts.domain.repository.PostsRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class FeaturePostsRepositoryModule {

    @Binds
    abstract fun bindPostRepository(defaultPostsRepository: DefaultPostsRepository): PostsRepository

}