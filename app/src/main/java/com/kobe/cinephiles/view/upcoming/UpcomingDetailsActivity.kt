package com.kobe.cinephiles.view.upcoming

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.kobe.cinephiles.R
import com.kobe.cinephiles.databinding.ActivityUpcomingDetailsBinding
import com.kobe.cinephiles.model.UpcomingMovie
import kotlinx.android.synthetic.main.activity_upcoming_details.*
import org.koin.android.viewmodel.ext.android.viewModel

class UpcomingDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpcomingDetailsBinding
    private val viewModel: UpcomingViewModel by viewModel()
    private var movie: UpcomingMovie? = null
    private var isFavorite: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_upcoming_details)

        movie = intent.getParcelableExtra<UpcomingMovie>(EXTRA_MOVIE)

        if (movie != null) {
            binding.movie = movie
            initTitleBar()
            updateFab()

        } else {
            finish()
        }

        fabFavorite.setOnClickListener {
            toggleFavorite()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initTitleBar() {
        setSupportActionBar(toolbar)

        if (appBarLayout != null) {

            if (appBarLayout?.layoutParams is CoordinatorLayout.LayoutParams) {
                val lp = appBarLayout?.layoutParams as CoordinatorLayout.LayoutParams
                lp.height = resources.displayMetrics.widthPixels
            }

        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if (collapsingToolbar != null) {
            supportActionBar?.setDisplayShowTitleEnabled(true)

        } else {
            supportActionBar?.setDisplayShowTitleEnabled(false)
        }
    }

    private fun updateFab() {
        isFavorite = viewModel.isFavorite(movie!!)

        val icon = getFabIcon(isFavorite)
        fabFavorite.setImageDrawable(icon)
    }

    private fun toggleFavorite() {
        if (isFavorite) viewModel.deleteFavorite(movie!!) else viewModel.saveFavorite(movie!!)
        updateFab()
    }

    private fun getFabIcon(favorite: Boolean): Drawable? {
        return ContextCompat.getDrawable(this,
            if (favorite) R.drawable.ic_favorite_check else R.drawable.ic_favorite_uncheck)
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
