package com.etoolkit.myapp.presention.detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemDetailBinding
import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail

class DetailAdapter : RecyclerView.Adapter<DetailAdapter.DetailViewHolder>() {

    var images = emptyList<String>()

    class DetailViewHolder(private val binding: ItemDetailBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(resultDataDetail: String){

            Glide.with(binding.root)
                .load(resultDataDetail)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.detailImage)

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {
        val binding = ItemDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return DetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        holder.bind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(results : List<String>) {
        this.images = results
        notifyDataSetChanged()
    }

}