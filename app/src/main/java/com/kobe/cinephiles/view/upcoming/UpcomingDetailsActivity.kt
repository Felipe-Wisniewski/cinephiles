package com.kobe.cinephiles.view.upcoming

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.DataBindingUtil
import com.kobe.cinephiles.R
import com.kobe.cinephiles.databinding.ActivityUpcomingDetailsBinding
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.activity_upcoming_details.*

class UpcomingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpcomingDetailsBinding
    private var movie: UpcomingMovie? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_upcoming_details)

        movie = intent.getParcelableExtra<UpcomingMovie>(EXTRA_MOVIE)

        if (movie != null) {
            binding.movie = movie
            initTitleBar()

        } else {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()

    }

    private fun initTitleBar() {
        setSupportActionBar(toolbar)

        if (appBar != null) {
            if (appBar?.layoutParams is CoordinatorLayout.LayoutParams) {
                val lp = appBar?.layoutParams as CoordinatorLayout.LayoutParams
                lp.height = resources.displayMetrics.widthPixels
            }
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (collapsingToolbar != null) {
            supportActionBar?.setDisplayShowTitleEnabled(true)
            Log.d("FLMWG","collapsing true")

        } else {
            supportActionBar?.setDisplayShowTitleEnabled(false)
            Log.d("FLMWG","collapsing false")
        }
    }

    companion object {
        const val EXTRA_MOVIE = "movie"

        fun start(context: Context, movie: UpcomingMovie?) {
            context.startActivity(Intent(context, UpcomingDetailsActivity::class.java).apply {
                putExtra(EXTRA_MOVIE, movie)
            })
        }
    }
}
