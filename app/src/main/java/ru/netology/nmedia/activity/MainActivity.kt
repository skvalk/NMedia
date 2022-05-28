package ru.netology.nmedia.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import ru.netology.nmedia.adapter.PostsAdapter
import ru.netology.nmedia.databinding.ActivityMainBinding
import ru.netology.nmedia.util.hideKeyboard
import ru.netology.nmedia.util.showKeyboard
import ru.netology.nmedia.viewmodel.PostViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel by viewModels<PostViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = PostsAdapter(viewModel)

        binding.list.adapter = adapter
        viewModel.data.observe(this) { posts ->
            adapter.submitList(posts)
        }

        binding.close.setOnClickListener {
            viewModel.onButtonCancelClicked()
        }

        binding.save.setOnClickListener {
            with(binding.contentEdit) {
                val content = text.toString()
                viewModel.onButtonSaveClicked(content)
            }
        }

        viewModel.currentPost.observe(this) { currentPost ->
            with(binding) {
                val content = currentPost?.content
                contentEdit.setText(content)
                previousText.hint = content
                if (content != null) {
                    contentEdit.requestFocus()
                    contentEdit.showKeyboard()
                    editGroup.visibility = View.VISIBLE
                } else {
                    contentEdit.clearFocus()
                    contentEdit.hideKeyboard()
                    editGroup.visibility = View.GONE
                }
            }

        }
    }
}