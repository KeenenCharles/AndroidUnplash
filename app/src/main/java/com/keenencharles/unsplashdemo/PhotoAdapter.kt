package com.keenencharles.unsplashdemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.keenencharles.unsplash.models.Photo
import com.keenencharles.unsplashdemo.databinding.ItemPhotoBinding
import com.squareup.picasso.Picasso
import java.util.Collections.emptyList

class PhotoAdapter(private var onSelected: (Photo) -> Unit) : RecyclerView.Adapter<PhotoAdapter.ViewHolder>() {

    private var photos: List<Photo> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val photo = photos[position]
        holder.bind(photo)


        holder.binding.root.setOnClickListener {
            run {
                onSelected(photo)
            }
        }
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    fun updateList(items: List<Photo>) {
        this.photos = items
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: Photo) {
            Picasso.get().load(photo.urls?.small).into(binding.imageView)
            binding.executePendingBindings()
        }
    }

}
