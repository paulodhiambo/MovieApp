package com.odhiambopaul.movie.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.databinding.ActivityDetailBinding
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import com.odhiambopaul.movie.ui.adapter.SimilarMoviesAdapter
import com.odhiambopaul.movie.ui.home.HomeActivity
import com.odhiambopaul.movie.util.image_path
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityDetailBinding
    private val similarAdapter by lazy { SimilarMoviesAdapter() }

    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        val movieId = intent.getStringExtra("id")
        val poster = intent.getStringExtra("poster")
        val release_date = intent.getStringExtra("release_date")
        val overview = intent.getStringExtra("overview")
        viewModel.similarMovies(movieId)

        viewModel.similarMovie.observe(this, Observer { movies ->
            similar_recycler.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(
                    this@DetailActivity,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
                if (movies.isEmpty()) {
                    binding.textS.visibility = View.GONE
                }
                similarAdapter.addItems(movies)
                adapter = similarAdapter
                similarAdapter.listener = { _, item, _ ->
                    val id = item.id.toString()
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("id", id)
                    intent.putExtra("poster", item.poster_path)
                    intent.putExtra("release_date", item.release_date)
                    intent.putExtra("language", item.original_language)
                    intent.putExtra("overview", item.overview)
                    intent.putExtra("title", item.title)
                    context.startActivity(intent)
                }
            }
        })
        Glide.with(this@DetailActivity)
            .load("$image_path${poster}")
            .into(poster_image)
        text_release_date.text = "Release Date: $release_date"
        text_overview.text = "Overview\n $overview"
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
