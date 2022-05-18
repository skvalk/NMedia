package ru.netology.nmedia.viewmodel

import androidx.lifecycle.ViewModel
import ru.netology.nmedia.repository.PostRepository
import ru.netology.nmedia.repository.PostRepositoryInMemoryImpl

class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositoryInMemoryImpl()

    val data by repository::data

    fun onLikeClicked() = repository.like()
    fun onSharedClicked() = repository.share()
    fun onViewsClicked() = repository.view()
}