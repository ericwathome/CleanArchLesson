package tech.ericwathome.cleanarchprac.feature_posts.presentation.posts_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import tech.ericwathome.cleanarchprac.feature_posts.core.util.DispatcherProvider
import tech.ericwathome.cleanarchprac.feature_posts.core.util.Resource
import tech.ericwathome.cleanarchprac.feature_posts.core.util.UiEvent
import tech.ericwathome.cleanarchprac.feature_posts.domain.use_case.PostsUseCases
import javax.inject.Inject

@HiltViewModel
class PostsViewModel @Inject constructor(
    private val useCases: PostsUseCases,
    private val dispatcher: DispatcherProvider
) : ViewModel() {

    var state: PostsState by mutableStateOf(PostsState())
        private set

    private var _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        getPosts()
    }

    fun onEvent(event: PostsEvent) {
        when (event) {
            is PostsEvent.OnClickAddPost -> {
                viewModelScope.launch { _uiEvent.send(UiEvent.Success<Unit>()) }
            }
            is PostsEvent.OnClickPost -> {
                viewModelScope.launch { _uiEvent.send(UiEvent.Success(data = event.postId)) }
            }
        }
    }

    private fun getPosts() {
        viewModelScope.launch(dispatcher.main) {
            useCases.getPosts().onEach { resource ->
                when (resource) {
                    is Resource.Success -> {
                        state = state.copy(
                            posts = resource.data ?: emptyList(),
                            loading = false
                        )
                    }

                    is Resource.Error -> {
                        state = state.copy(
                            loading = false,
                            error = true,
                            errorMessage = resource.message ?: "An unknown error occurred",
                            showDialog = true
                        )
                    }

                    is Resource.Loading -> {
                        state = state.copy(loading = true)
                    }
                }
            }
        }
    }

}