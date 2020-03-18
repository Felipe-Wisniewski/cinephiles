package com.kobe.cinephiles.ui.upcoming

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.*
import com.kobe.cinephiles.R
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.fragment_upcoming_list.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingWebListFragment : Fragment() {

    private val viewModel: UpcomingViewModel by viewModel()

    lateinit var upcomingAdapter: UpcomingAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_upcoming_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        showProgress(true)

        upcomingAdapter = UpcomingAdapter(this@UpcomingWebListFragment::onItemClick)
        setupAdapter()
        loadMovies()
    }

    private fun setupAdapter() {
        rvUpcoming.run {
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
        viewModel.moviesList.observe(viewLifecycleOwner, Observer { movies ->
            showProgress(false)
            upcomingAdapter.submitList(movies)
        })
    }

    private fun onItemClick(movie: UpcomingMovie?) {
        Log.d("FLMWG", "movie title - $movie")

        activity?.run {
//            val intent = Intent(this, )
        }
    }

    private fun showProgress(show: Boolean) {
        swpRefresh.post {
            swpRefresh.isRefreshing = show
        }
    }
}