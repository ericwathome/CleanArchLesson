package tech.ericwathome.cleanarchprac.feature_posts.data.mappers

import tech.ericwathome.cleanarchprac.feature_posts.data.datasource.remote.dto.PostDto
import tech.ericwathome.cleanarchprac.feature_posts.domain.model.Post

fun PostDto.toPost(): Post {
    return Post(
        body = body,
        id = id,
        reactions = reactions,
        tags = tags,
        title = title,
        userId = userId
    )
}