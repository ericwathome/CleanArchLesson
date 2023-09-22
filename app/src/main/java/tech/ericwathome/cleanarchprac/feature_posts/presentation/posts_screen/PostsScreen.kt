package tech.ericwathome.cleanarchprac.feature_posts.presentation.posts_screen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import tech.ericwathome.cleanarchprac.feature_posts.core.util.UiEvent

@Composable
fun PostsScreen(
    viewModel: PostsViewModel = hiltViewModel(),
    navigateToPostDetails: (Int) -> Unit,
    navigateToCreatePost: () -> Unit
) {
    PostsScreenContent(
        state = viewModel.state,
        onEvent = viewModel::onEvent,
        navigateToPostDetails = navigateToPostDetails,
        uiEvent = viewModel.uiEvent,
        navigateToCreatePost = navigateToCreatePost
    )
}

@Composable
fun PostsScreenContent(
    state: PostsState,
    onEvent: (PostsEvent) -> Unit,
    navigateToPostDetails: (Int) -> Unit,
    navigateToCreatePost: () -> Unit,
    uiEvent: Flow<UiEvent>
) {
    LaunchedEffect(key1 = true) {
        uiEvent.collect { uiEvent ->
            when (uiEvent) {
                is UiEvent.Success<*> -> {
                    if (uiEvent.data != null) {
                        navigateToPostDetails(uiEvent.data as Int)
                    } else {
                        navigateToCreatePost()
                    }
                }
                else -> Unit
            }
        }
    }


}

@Preview
@Composable
fun PostsScreenPreview() {
    PostsScreenContent(
        state = PostsState(),
        onEvent = { },
        navigateToPostDetails = { },
        uiEvent = flowOf(),
        navigateToCreatePost = { }
    )
}