package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import ru.netology.nmedia.R
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post
import ru.netology.nmedia.viewmodel.PostViewModel
import kotlin.math.floor

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel by viewModels<PostViewModel>()

        viewModel.data.observe(this) { post ->
            binding.render(post)
        }

        binding.like.setOnClickListener {
            viewModel.onLikeClicked()
        }

        binding.share.setOnClickListener{
            viewModel.onSharedClicked()
        }

        binding.views.setOnClickListener{
            viewModel.onViewsClicked()
        }

    }

    private fun ActivityMainBinding.render(post: Post){
        author.text = post.author
        published.text = post.published
        content.text = post.content
        likeCount.text = getFormattedNumber(post.likes)
        shareCount.text = getFormattedNumber(post.shared)
        viewsCount.text = getFormattedNumber(post.views)

        like.setImageResource(
            if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
        )
    }

    private fun getFormattedNumber(number: Int): String {
        return when (number) {
            0 -> ""
            in 1..999 -> String.format(getString(R.string.numberOnes), number.toFloat())
            in 1_000..1_099 -> String.format(
                getString(R.string.numberThousands),
                floor(number.toDouble() / 100) / 10
            )
            in 1_100..9_999 -> String.format(
                getString(R.string.numberThousandsAndHundreds),
                floor(number.toDouble() / 100) / 10
            )
            in 10_000..999_999 -> String.format(
                getString(R.string.numberThousands),
                floor(number.toDouble() / 100) / 10
            )
            in 1_000_000..1_099_000 -> String.format(
                getString(R.string.numberMillions),
                floor(number.toDouble() / 100_000) / 10
            )
            in 1_100_000..9_999_999 -> String.format(
                getString(R.string.numberMillionsAndThousands),
                floor(number.toDouble() / 100_000) / 10
            )
            else -> String.format(
                getString(R.string.numberMillions),
                floor(number.toDouble() / 100_000) / 10
            )
        }
    }
}