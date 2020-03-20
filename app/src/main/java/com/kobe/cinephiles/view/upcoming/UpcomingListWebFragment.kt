package com.kobe.cinephiles.view.upcoming

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.*
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.fragment_upcoming_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingListWebFragment : UpcomingListBaseFragment() {

    private val viewModel: UpcomingViewModel by viewModel()

    private val upcomingAdapter = UpcomingAdapterWeb(this::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        swpRefresh.isEnabled = false

        setupAdapter()
        loadMovies()
    }

    private fun setupAdapter() {
        rvUpcoming.run {
            tag = "web"
            setHasFixedSize(true)

            val orientation = resources.configuration.orientation

            layoutManager = if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                LinearLayoutManager(activity)

            } else {
                GridLayoutManager(activity, 2)
            }

            addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
            itemAnimator = DefaultItemAnimator()
            adapter = upcomingAdapter
        }
    }

    private fun loadMovies() {
        viewModel.getMoviesUpcoming().observe(viewLifecycleOwner, Observer { movies ->
            Log.d("FLMWG", "movies.isDetached - ${movies.isDetached}")
            Log.d("FLMWG", "movies.isImmutable - ${movies.isImmutable}")
            upcomingAdapter.submitList(movies)
        })
    }

    private fun onItemClick(movie: UpcomingMovie?) {
        UpcomingDetailsActivity.start(this.requireContext(), movie)
    }
}