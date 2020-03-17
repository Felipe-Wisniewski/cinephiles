package com.kobe.cinephiles.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.kobe.cinephiles.R
import com.squareup.picasso.Picasso

object ImageBinding {

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {

        var completeUrl = "https://image.tmdb.org/t/p/w500"

        if (url != null) {
            completeUrl += url
        }

        Picasso.get()
            .load(completeUrl)
            .placeholder(R.drawable.ic_image_error)
            .into(imageView)

    }

}