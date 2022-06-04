package ru.netology.nmedia.ui

import android.widget.PopupMenu
import ru.netology.nmedia.R
import ru.netology.nmedia.adapter.PostInteractionListener
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import kotlin.math.floor

fun CardPostBinding.listen(post: Post, listener: PostInteractionListener) {
    val popupMenu by lazy {
        PopupMenu(root.context, menu).apply {
            inflate(R.menu.options_post)
            setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.remove -> {
                        listener.onButtonRemoveClicked(post)
                        true
                    }
                    R.id.edit -> {
                        listener.onButtonEditClicked(post)
                        true
                    }
                    else -> false
                }
            }
        }
    }

    like.setOnClickListener { listener.onButtonLikesClicked(post) }
    share.setOnClickListener { listener.onButtonRepostsClicked(post) }
    buttonPlayVideo.setOnClickListener { listener.onButtonPlayVideoClicked(post) }
    menu.setOnClickListener { popupMenu.show() }
    postLayout.setOnClickListener { listener.onContentClicked(post) }
}

fun CardPostBinding.bind(post: Post) {
    author.text = post.author
    published.text = post.published
    content.text = post.content
    like.text = getFormattedNumber(post.likes)
    share.text = getFormattedNumber(post.shared)
    views.text = getFormattedNumber(post.views)
    like.isChecked = post.likedByMe
    groupVideo.visibility =
        if (post.videoURL.isBlank()) android.view.View.GONE else android.view.View.VISIBLE

}

private fun getFormattedNumber(number: Int): String {
    return when (number) {
        0 -> ""
        in 1..999 -> String.format("%.0f", number.toFloat())
        in 1_000..1_099 -> String.format(
            "%.0fK", floor(number.toDouble() / 100) / 10
        )
        in 1_100..9_999 -> String.format(
            "%.1fK",
            floor(number.toDouble() / 100) / 10
        )
        in 10_000..999_999 -> String.format(
            "%.0fK",
            floor(number.toDouble() / 100) / 10
        )
        in 1_000_000..1_099_000 -> String.format(
            "%.0fM",
            floor(number.toDouble() / 100_000) / 10
        )
        in 1_100_000..9_999_999 -> String.format(
            "%.1fM",
            floor(number.toDouble() / 100_000) / 10
        )
        else -> String.format(
            "%.0fM",
            floor(number.toDouble() / 100_000) / 10
        )
    }
}