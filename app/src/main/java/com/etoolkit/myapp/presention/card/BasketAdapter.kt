package com.etoolkit.myapp.presention.card

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemCartLayoutBinding
import com.etoolkit.myapp.domain.card.model.Basket

class BasketAdapter : RecyclerView.Adapter<BasketAdapter.BasketHolder>() {

    var baskets = emptyList<Basket>()

    class BasketHolder(private val binding: ItemCartLayoutBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(basket: Basket){

            Glide.with(binding.root)
                .load(basket.images)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.image)

            binding.title.text = basket.title
            binding.price.text = basket.price.toString()
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BasketHolder {
        val binding = ItemCartLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BasketHolder(binding)
    }

    override fun onBindViewHolder(holder: BasketHolder, position: Int) {
        holder.bind(baskets[position])
    }

    override fun getItemCount(): Int {
        return baskets.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(baskets : List<Basket>) {
        this.baskets = baskets
        notifyDataSetChanged()
    }

}