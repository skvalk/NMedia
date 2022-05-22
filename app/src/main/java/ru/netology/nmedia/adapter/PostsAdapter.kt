package ru.netology.nmedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.CardPostBinding
import ru.netology.nmedia.dto.Post
import kotlin.math.floor


internal class PostsAdapter(
    private val onLikeClicked: (Post) -> Unit,
    private val onSharedClicked: (Post) -> Unit
) : ListAdapter<Post, PostsAdapter.ViewHolder>(DiffCallback) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = CardPostBinding.inflate(inflater, parent, false)

        return ViewHolder(
            binding,
            onLikeClicked,
            onSharedClicked
        )
    }

    class ViewHolder(
        private val binding: CardPostBinding,
        onLikeClicked: (Post) -> Unit,
        onSharedClicked: (Post) -> Unit,
    ) : RecyclerView.ViewHolder(binding.root) {

        private lateinit var post: Post

        init {
            binding.like.setOnClickListener { onLikeClicked(post) }
            binding.share.setOnClickListener { onSharedClicked(post) }
        }

        fun bind(post: Post) {
            this.post = post

            with(binding) {
                author.text = post.author
                published.text = post.published
                content.text = post.content
                likeCount.text = getFormattedNumber(post.likes)
                shareCount.text = getFormattedNumber(post.shared)
                viewsCount.text = getFormattedNumber(post.views)
                like.setImageResource(getButtonLikesIconResId(post.likedByMe))
            }
        }

        @DrawableRes
        private fun getButtonLikesIconResId(liked: Boolean) =
            if (liked) R.drawable.ic_liked_24 else R.drawable.ic_like_24

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

    }

    private object DiffCallback : DiffUtil.ItemCallback<Post>() {

        override fun areItemsTheSame(oldItem: Post, newItem: Post) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Post, newItem: Post) =
            oldItem == newItem

    }
}