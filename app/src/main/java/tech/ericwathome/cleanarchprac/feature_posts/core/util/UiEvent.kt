package tech.ericwathome.cleanarchprac.feature_posts.core.util

sealed class UiEvent {
    data class Success<T>(val data: T? = null) : UiEvent()
    data class ShowMessage(val message: String) : UiEvent()
    object Error : UiEvent()
    object NavigateUp : UiEvent()
    object Refresh : UiEvent()
}
