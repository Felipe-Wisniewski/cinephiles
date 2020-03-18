package com.kobe.cinephiles.view.upcoming

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.fragment_upcoming_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingListDbFragment : UpcomingListBaseFragment() {

    private val viewModel: UpcomingViewModel by viewModel()
    lateinit var favAdapter: UpcomingFavAdapter
    private var movies = mutableListOf<UpcomingMovie>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favAdapter = UpcomingFavAdapter(movies, this::onItemClick)
        setupAdapter()
        loadMovies()
    }

    private fun setupAdapter() {
        rvUpcoming.run {
            tag = "fav"
            setHasFixedSize(true)

            val orientation = resources.configuration.orientation

            layoutManager = if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                LinearLayoutManager(activity)

            } else {
                GridLayoutManager(activity, 2)
            }

            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = favAdapter
        }
    }

    private fun loadMovies() {
        viewModel.moviesFavorites.observe(viewLifecycleOwner, Observer { movies ->
            favAdapter.addMovies(movies)
        })
    }

    private fun onItemClick(movie: UpcomingMovie?) {
        UpcomingDetailsActivity.start(this.requireContext(), movie)
    }
}