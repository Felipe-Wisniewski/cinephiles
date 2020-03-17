package com.kobe.cinephiles.ui.upcoming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.kobe.cinephiles.R
import com.kobe.cinephiles.databinding.UpcomingItemBinding
import com.kobe.cinephiles.model.UpcomingMovie

class UpcomingAdapter(private val movies: List<UpcomingMovie>,
                      private val onItemClick: (UpcomingMovie) -> Unit) : RecyclerView.Adapter<UpcomingAdapter.VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_item, parent, false)
        return VH(view)
    }

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.binding?.run {

            val currentMovie = movies[position]
            movie = currentMovie

            root.setOnClickListener {
                onItemClick(currentMovie)
            }

            executePendingBindings()

        }
    }

    class VH(view: View) : RecyclerView.ViewHolder(view) {
        val binding = DataBindingUtil.bind<UpcomingItemBinding>(view)
    }
}
