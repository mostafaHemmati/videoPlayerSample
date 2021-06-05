package com.hemmati.namavatest.view.searchListFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.hemmati.namavatest.R
import com.hemmati.namavatest.databinding.ListItemVideoBinding
import com.hemmati.namavatest.domain.model.videos.Data
import kotlin.properties.Delegates

class VideosAdapter :
    RecyclerView.Adapter<VideosAdapter.VideoViewHolder>() {

    var onItemClick: ((Data) -> Unit)? = null
    var videos: List<Data> by Delegates.observable(emptyList()) { _, _, _ ->
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val holderVideoBinding = DataBindingUtil.inflate<ListItemVideoBinding>(
            LayoutInflater.from(parent.context), R.layout.list_item_video, parent, false
        )
        return VideoViewHolder(holderVideoBinding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        holder.bind(videos[position])

    }

    override fun getItemCount(): Int = if (videos.isNullOrEmpty()) 0 else videos.size


    inner class VideoViewHolder(private val viewDataBinding: ListItemVideoBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {

        fun bind(data: Data) {
            itemView.setOnClickListener {
                onItemClick?.invoke(data)
            }
            viewDataBinding.videoData = data

        }

    }


}