package com.kobe.cinephiles.view.upcoming

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.kobe.cinephiles.R
import com.kobe.cinephiles.databinding.UpcomingItemBinding
import com.kobe.cinephiles.model.UpcomingMovie

class UpcomingAdapterWeb(private val onItemClick: (UpcomingMovie?) -> Unit) : PagedListAdapter<UpcomingMovie, UpcomingAdapterWeb.VH>(movieDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.upcoming_item, parent, false)
        return VH(view)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {

        holder.binding?.run {

            val currentMovie = getItem(position)

            if (currentMovie?.poster_path == null) {
                currentMovie?.poster_path = ""
            }

            if (currentMovie?.backdrop_path == null) {
                currentMovie?.backdrop_path = currentMovie?.poster_path!!
            }

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

    companion object {
        val movieDiff = object : DiffUtil.ItemCallback<UpcomingMovie>() {
            override fun areItemsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: UpcomingMovie, newItem: UpcomingMovie): Boolean {
                return oldItem == newItem
            }

        }
    }
}
