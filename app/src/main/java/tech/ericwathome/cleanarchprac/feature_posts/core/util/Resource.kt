package tech.ericwathome.cleanarchprac.feature_posts.core.util

sealed class Resource<T>(val data: T?, val message: String?) {
    class Success<T>(data: T): Resource<T>(data, null)
    class Error<T>(message: String): Resource<T>(null, message)
    class Loading<T>: Resource<T>(null, null)
}
