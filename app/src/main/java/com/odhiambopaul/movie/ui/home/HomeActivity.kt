package com.odhiambopaul.movie.ui.home

import android.content.Intent
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Display
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.databinding.ActivityHomeBinding
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import com.odhiambopaul.movie.ui.adapter.HomeRecylerAdapter
import com.odhiambopaul.movie.ui.detail.DetailActivity
import com.odhiambopaul.movie.ui.search.SearchActivity
import com.odhiambopaul.movie.util.hide
import com.odhiambopaul.movie.util.show
import com.odhiambopaul.movie.util.snackbar
import javax.inject.Inject
import kotlin.math.round

class HomeActivity : AppCompatActivity(), MovieListener {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityHomeBinding
    private val homeAdapter by lazy {
        HomeRecylerAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(HomeViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.getMovie()
        viewModel.movies.observe(this, Observer { movies ->
            binding.movieRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager =
                    GridLayoutManager(this@HomeActivity, calculateNoOfColumns())
                adapter = homeAdapter
                homeAdapter.addItems(movies)
                homeAdapter.listener = { _, item, _ ->
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
    }

    private fun calculateNoOfColumns(): Int {
        //getting the screen size
        val display: Display = this.windowManager.defaultDisplay
        val outmetrics = DisplayMetrics()
        display.getMetrics(outmetrics)
        val density: Float = resources.displayMetrics.density
        val dpwidth: Float = outmetrics.widthPixels / density
        return round(dpwidth / 190).toInt()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.options_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.search_menu -> {
                startActivity(Intent(this, SearchActivity::class.java))
                true
            }
            R.id.sort -> {
                Toast.makeText(this, "Sort", Toast.LENGTH_LONG).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onFetchStarted() {
        binding.progressBar.show()
    }

    override fun onFetchFinished() {
        binding.progressBar.visibility = View.GONE
        binding.progressBar.hide()
    }

    override fun onFailure(message: String) {
        binding.progressBar.hide()
        binding.root.snackbar(message)
    }
}