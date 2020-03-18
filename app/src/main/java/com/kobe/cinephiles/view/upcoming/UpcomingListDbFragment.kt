package com.kobe.cinephiles.view.upcoming

import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.fragment_upcoming_list.*

class UpcomingListDbFragment : UpcomingListBaseFragment() {

    lateinit var upcomingAdapter: UpcomingAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        upcomingAdapter = UpcomingAdapter(this::onItemClick)
        setupAdapter()
        loadMovies()
    }

    private fun setupAdapter() {
        rvUpcoming.run {
            tag = "db"
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
        Log.d("FLMWG", "loadMovies")
    }

    private fun onItemClick(movie: UpcomingMovie?) {
        UpcomingDetailsActivity.start(this.requireContext(), movie)
    }
}