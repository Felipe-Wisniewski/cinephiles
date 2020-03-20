package com.kobe.cinephiles.binding

import android.widget.RatingBar
import androidx.databinding.BindingAdapter

object RatingBinding {

    @JvmStatic
    @BindingAdapter("app:ratingAverage")
    fun setRatingMovie(ratingBar: RatingBar, rating: Float?) {
        val rtg = if (rating != null) rating * 0.5f else 0f
        ratingBar.rating = rtg
    }

}