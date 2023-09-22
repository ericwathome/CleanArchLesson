package tech.ericwathome.cleanarchprac.feature_posts.core.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.ericwathome.cleanarchprac.feature_posts.core.util.DefaultDispatcherProvider
import tech.ericwathome.cleanarchprac.feature_posts.core.util.DispatcherProvider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CoreModule {

    @Provides
    @Singleton
    fun provideDispatcherProvider(): DispatcherProvider {
        return DefaultDispatcherProvider()
    }

}