package ru.netology.nmedia.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImpl
import ru.netology.nmedia.adapter.PostInteractionListener

class PostViewModel: ViewModel(), PostInteractionListener {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data by repository::data

//    fun onLikeClicked(post: Post) = repository.like(post.id)
//
//    fun onSharedClicked(post: Post) = repository.share(post.id)

    val currentPost = MutableLiveData<Post?>(null)

    fun onButtonSaveClicked(content: String) {
        if (content.isBlank()) return

        val post = currentPost.value?.copy(
            content = content
        ) ?: Post(
            id = 0L,
            author = "Me",
            content = content,
            published = "today",
        )
        repository.save(post)
        currentPost.value = null
    }

    override fun onButtonLikesClicked(post: Post) =
        repository.like(post.id)

    override fun onButtonRepostsClicked(post: Post) =
        repository.share(post.id)

    override fun onButtonRemoveClicked(post: Post) =
        repository.remove(post.id)

    override fun onButtonEditClicked(post: Post) {
        currentPost.value = post
    }

    override fun onButtonCancelClicked() {
        currentPost.value = null
    }
}