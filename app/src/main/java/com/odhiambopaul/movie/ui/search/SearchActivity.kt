package com.odhiambopaul.movie.ui.search

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.SearchView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.odhiambopaul.movie.App
import com.odhiambopaul.movie.R
import com.odhiambopaul.movie.data.entity.Movie
import com.odhiambopaul.movie.databinding.ActivitySearchBinding
import com.odhiambopaul.movie.di.component.DaggerApplicationComponent
import com.odhiambopaul.movie.ui.detail.DetailActivity
import com.odhiambopaul.movie.util.api_key
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_search.*
import javax.inject.Inject


class SearchActivity : AppCompatActivity() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerApplicationComponent.factory().create(this.application as App).inject(this)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search)
        binding.searchView.queryHint = "Search Movie"
        binding.searchView.onActionViewExpanded()
        val viewModel = ViewModelProvider(this, viewModelFactory).get(SearchViewModel::class.java)
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //code
                searchMovie(viewModel, query!!)
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //should also call getSearchedMovie
                searchMovie(viewModel, newText!!)
                return false
            }
        })
    }

    fun searchMovie(viewModel: SearchViewModel, movieTitle: String) {
        viewModel.run {
            getSearchResponse(api_key, movieTitle)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ data ->
                    val searchListM: MutableList<String> = ArrayList()
                    val movies: MutableList<Movie> = ArrayList()
                    data.results.forEach {
                        searchListM.add(it.title)
                        movies.add(it)
                    }
                    val adapter = ArrayAdapter(
                        this@SearchActivity,
                        android.R.layout.simple_list_item_1,
                        searchListM
                    )
                    this@SearchActivity.searchList.adapter = adapter
                    binding.searchList.onItemClickListener =
                        OnItemClickListener { parent, _, position, _ ->
                            parent.getItemAtPosition(position) as String
                            val intent =
                                Intent(this@SearchActivity, DetailActivity::class.java)
                            intent.putExtra("id", movies[position].id.toString())
                            intent.putExtra("poster", movies[position].poster_path)
                            intent.putExtra("release_date", movies[position].release_date)
                            intent.putExtra("language", movies[position].original_language)
                            intent.putExtra("overview", movies[position].overview)
                            intent.putExtra("title", movies[position].title)
                            startActivity(intent)
                        }
                }, { t -> onResponseError(t.localizedMessage) })
        }
    }

    @SuppressLint("LogNotTimber")
    private fun onResponseError(localizedMessage: String?) {
        Log.e("Error::", localizedMessage!!)
    }
}
