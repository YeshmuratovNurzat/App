package com.etoolkit.myapp.presention.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemBestSellerBinding
import com.etoolkit.myapp.domain.model.BestSeller


class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {

    private var bestSellers = emptyList<BestSeller>()

    class BestSellerViewHolder(val binding: ItemBestSellerBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(bestSeller: BestSeller){

            Glide.with(binding.root)
                .load(bestSeller.picture)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.bestSellerImage)

            binding.bestSellerMoney.text = "$${bestSeller.discount_price}"
            binding.bestSellerOldMoney.text = "$${bestSeller.price_without_discount}"
            binding.bestSellerName.text = bestSeller.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = ItemBestSellerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {
        holder.bind(bestSellers[position])
    }

    override fun getItemCount(): Int {
        return bestSellers.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(bestSellers: List<BestSeller>) {
        this.bestSellers = bestSellers
        notifyDataSetChanged()
    }

}