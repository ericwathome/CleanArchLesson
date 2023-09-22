package tech.ericwathome.cleanarchprac.feature_posts.core.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

inline fun <T> safeApiCall(
    crossinline apiCall: suspend () -> T
): Flow<Resource<T>> = flow {
    try {
        emit(Resource.Loading())
        emit(Resource.Success(apiCall()))
    } catch (e: Exception) {
        emit(Resource.Error(e.message ?: "An unknown error occurred"))
    }
}