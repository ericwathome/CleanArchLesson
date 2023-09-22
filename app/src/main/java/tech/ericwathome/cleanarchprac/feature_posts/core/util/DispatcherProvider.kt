package tech.ericwathome.cleanarchprac.feature_posts.core.util

import kotlinx.coroutines.CoroutineDispatcher

interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
    val unconfined: CoroutineDispatcher
}

class DefaultDispatcherProvider : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = kotlinx.coroutines.Dispatchers.Main
    override val io: CoroutineDispatcher
        get() = kotlinx.coroutines.Dispatchers.IO
    override val default: CoroutineDispatcher
        get() = kotlinx.coroutines.Dispatchers.Default
    override val unconfined: CoroutineDispatcher
        get() = kotlinx.coroutines.Dispatchers.Unconfined
}