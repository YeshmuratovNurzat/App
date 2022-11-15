package com.etoolkit.myapp.presention.home

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemBestSellerBinding
import com.etoolkit.myapp.domain.home.model.BestSeller

class BestSellerAdapter : RecyclerView.Adapter<BestSellerAdapter.BestSellerViewHolder>() {

    private var bestSellers = emptyList<BestSeller>()

    var onClick : ((BestSeller) -> Unit)? = null
   
    class BestSellerViewHolder(private val binding: ItemBestSellerBinding) : RecyclerView.ViewHolder(binding.root){

        var isFavorite = false

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

            binding.buttonAddFavorite.setOnClickListener{

                if(!isFavorite){
                    binding.buttonAddFavorite.setImageDrawable(binding.root.context.resources.getDrawable(R.drawable.ic_favorite_1))
                    Toast.makeText(binding.root.context, "Добавлено в избранное", Toast.LENGTH_SHORT).show()
                    isFavorite = true
                }else{
                    binding.buttonAddFavorite.setImageDrawable(binding.root.context.resources.getDrawable(R.drawable.ic_favorite_icon))
                    Toast.makeText(binding.root.context, "Удалено из избранное", Toast.LENGTH_SHORT).show()
                    isFavorite = false
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellerViewHolder {
        val binding = ItemBestSellerBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BestSellerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BestSellerViewHolder, position: Int) {

        holder.bind(bestSellers[position])

        holder.itemView.setOnClickListener {
            onClick?.invoke(bestSellers[position])
        }
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