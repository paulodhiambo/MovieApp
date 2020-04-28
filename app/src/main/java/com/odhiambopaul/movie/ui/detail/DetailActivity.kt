package com.odhiambopaul.movie.ui.detail

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.databinding.ActivityDetailBinding
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import com.odhiambopaul.movie.ui.home.HomeActivity
import com.odhiambopaul.movie.util.api_key
import com.odhiambopaul.movie.util.image_path
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class DetailActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityDetailBinding

    @SuppressLint("CheckResult", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)
        val movieId = intent.getStringExtra("id")
        val poster = intent.getStringExtra("poster")
        val release_date = intent.getStringExtra("release_date")
        val language = intent.getStringExtra("original_language")
        val overview = intent.getStringExtra("overview")
        val title = intent.getStringExtra("title")
        Glide.with(this@DetailActivity)
            .load("$image_path${poster}")
            .into(poster_image)
        text_release_date.text = "Release Date: $release_date"
        text_overview.text = "Overview\n $overview"
        viewModel.getSimilarMovies(movieId, key = api_key)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ data ->
                similar_recycler.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(
                        this@DetailActivity,
                        LinearLayoutManager.HORIZONTAL,
                        false
                    )
                    adapter = SimilarMoviesAdapter(data.results, context)
                }
            }, { t -> Log.e("Error:::", t.localizedMessage) })
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, HomeActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }
}
