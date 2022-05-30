package ru.netology.nmedia.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.adapter.PostInteractionListener
import ru.netology.nmedia.repository.FilePostRepository
import ru.netology.nmedia.util.SingleLiveEvent

class PostViewModel(
    application: Application
) : AndroidViewModel(application), PostInteractionListener {
    private val repository: PostRepository = FilePostRepository(application)

    val data by repository::data

    val sharePostContent = SingleLiveEvent<String>()
    val navigateToPostContentScreenEvent = SingleLiveEvent<Unit>()
    val playVideoURL = SingleLiveEvent<String>()

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

    override fun onButtonPlayVideoClicked(post: Post) {
        playVideoURL.value = post.videoURL
    }

    override fun onButtonLikesClicked(post: Post) =
        repository.like(post.id)

    override fun onButtonRepostsClicked(post: Post) {
        sharePostContent.value = post.content
    }

    override fun onButtonRemoveClicked(post: Post) =
        repository.remove(post.id)

    override fun onButtonEditClicked(post: Post) {
        currentPost.value = post
        navigateToPostContentScreenEvent.call()
    }

    fun onAddClicked() {
        navigateToPostContentScreenEvent.call()
    }

}