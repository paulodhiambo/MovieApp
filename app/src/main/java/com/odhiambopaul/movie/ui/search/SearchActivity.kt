package com.odhiambopaul.movie.ui.search

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
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                //should also call getSearchedMovie
                viewModel.run {
                    getSearchResponse(api_key, newText!!)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({ data ->
                            val searchListM: MutableList<String> = ArrayList()
                            val movies:MutableList<Movie> = ArrayList()
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
                                    val item = parent.getItemAtPosition(position) as String
//                                    view.animate().setDuration(2000).alpha(0f)
//                                        .withEndAction {
//                                            searchListM.remove(item)
//                                            adapter.notifyDataSetChanged()
//                                            view.alpha = 1f
//                                        }
                                    val intent = Intent(this@SearchActivity, DetailActivity::class.java)
                                    intent.putExtra("id",movies[position].id.toString())
                                    intent.putExtra("poster", movies[position].poster_path)
                                    intent.putExtra("release_date", movies[position].release_date)
                                    intent.putExtra("language", movies[position].original_language)
                                    intent.putExtra("overview", movies[position].overview)
                                    intent.putExtra("title", movies[position].title)
                                    //clear the current activity
                                    //intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                    startActivity(intent)
                                }
                            Log.d("Success::", data.toString())
                        }, { t -> Log.e("Error::", t.localizedMessage!!) })
                }
                return false
            }
        })
    }
}
