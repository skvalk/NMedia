package ru.netology.nmedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.dto.Post


class MainActivity : AppCompatActivity() {
    private fun getFormattedNumber(number: Int): String {
        return when (number) {
            0 -> ""
            in 1..999 -> String.format(getString(R.string.numberOnes), number.toFloat())
            in 1_000..1_099 -> String.format(
                getString(R.string.numberThousands),
                kotlin.math.floor(number.toDouble() / 100) / 10
            )
            in 1_100..9_999 -> String.format(
                getString(R.string.numberThousandsAndHundreds),
                kotlin.math.floor(number.toDouble() / 100) / 10
            )
            in 10_000..999_999 -> String.format(
                getString(R.string.numberThousands),
                kotlin.math.floor(number.toDouble() / 100) / 10
            )
            in 1_000_000..1_099_000 -> String.format(
                getString(R.string.numberMillions),
                kotlin.math.floor(number.toDouble() / 100_000) / 10
            )
            in 1_100_000..9_999_999 -> String.format(
                getString(R.string.numberMillionsAndThousands),
                kotlin.math.floor(number.toDouble() / 100_000) / 10
            )
            else -> String.format(
                getString(R.string.numberMillions),
                kotlin.math.floor(number.toDouble() / 100_000) / 10
            )
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val post = Post(
            id = 1,
            author = "Нетология. Университет интернет-профессий будущего",
            content = "Привет, это новая Нетология! Когда-то Нетология начиналась с интенсивов по онлайн-маркетингу. Затем появились курсы по дизайну, разработке, аналитике и управлению. Мы растём сами и помогаем расти студентам: от новичков до уверенных профессионалов. Но самое важное остаётся с нами: мы верим, что в каждом уже есть сила, которая заставляет хотеть больше, целиться выше, бежать быстрее. Наша миссия — помочь встать на путь роста и начать цепочку перемен → http://netolo.gy/fyb",
            published = "21 мая в 18:36",
            likes = 1099,
            shared = 999,
            views = 1999999,
            likedByMe = false
        )


        with(binding) {
            author.text = post.author
            published.text = post.published
            content.text = post.content
            shareCount.text = getFormattedNumber(post.shared)
            viewsCount.text = getFormattedNumber(post.views)
            if (post.likedByMe) {
                like.setImageResource(R.drawable.ic_liked_24)
            }
            likeCount.text = getFormattedNumber(post.likes)

            like.setOnClickListener {
                post.likedByMe = !post.likedByMe
                like.setImageResource(
                    if (post.likedByMe) R.drawable.ic_liked_24 else R.drawable.ic_like_24
                )
                if (post.likedByMe) post.likes++ else post.likes--
                likeCount.text = getFormattedNumber(post.likes)
            }

            share.setOnClickListener{
                shareCount.text = getFormattedNumber(post.shared++)
            }
            views.setOnClickListener{
                viewsCount.text = getFormattedNumber(post.views++)
            }
        }
    }
}