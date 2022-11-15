package com.etoolkit.myapp.presention.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemHotSalesBinding
import com.etoolkit.myapp.domain.home.model.HomeStore

class HotSalesAdapter : RecyclerView.Adapter<HotSalesAdapter.HotSalesViewHolder>() {

    private var homeStore = emptyList<HomeStore>()

    class HotSalesViewHolder(private val binding: ItemHotSalesBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(homeStore : HomeStore){

            Glide.with(binding.root)
                .load(homeStore.picture)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.hotSalesImage)

            binding.hotSalesTitle.text = homeStore.title
            binding.hotSalesSubtitle.text = homeStore.subtitle
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotSalesViewHolder {
        val binding = ItemHotSalesBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return HotSalesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HotSalesViewHolder, position: Int) {
        holder.bind(homeStore[position])
    }

    override fun getItemCount(): Int {
        return homeStore.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(homeStore : List<HomeStore>) {
        this.homeStore = homeStore
        notifyDataSetChanged()
    }
}