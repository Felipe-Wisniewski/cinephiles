package com.kobe.cinephiles.binding

import android.util.Log
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kobe.cinephiles.R
import com.squareup.picasso.Picasso

object ImageBinding {

    @JvmStatic
    @BindingAdapter("app:imgUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {

        var completeUrl = "https://image.tmdb.org/t/p/w500"

        val errorImage = if (imageView.id == R.id.imgUpcomingPosterItem)
            R.drawable.img_not_available_poster
        else
            R.drawable.img_not_available_backdrop

        if (url != null) {
            completeUrl += url
        }

        Picasso.get()
            .load(completeUrl)
            .error(errorImage)
            .placeholder(R.drawable.ic_sync_black)
            .into(imageView)

    }

}