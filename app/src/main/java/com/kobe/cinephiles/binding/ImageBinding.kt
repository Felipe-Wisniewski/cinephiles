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

        if (url != null) {
            completeUrl += url
        }

        Log.d("FLMWG", completeUrl)

        Picasso.get()
            .load(completeUrl)
            .error(R.drawable.image_not_found)
            .placeholder(R.drawable.ic_image_error)
            .into(imageView)

    }

}