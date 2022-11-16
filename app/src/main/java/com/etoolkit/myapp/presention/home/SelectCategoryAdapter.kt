package com.etoolkit.myapp.presention.home

import android.annotation.SuppressLint
import android.content.res.ColorStateList
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemSelectCategoryBinding
import com.etoolkit.myapp.domain.home.model.Category

class SelectCategoryAdapter : RecyclerView.Adapter<SelectCategoryAdapter.SelectCategoryViewHolder>() {

    var category = emptyList<Category>()

    var onClickListener: ((Category) -> Unit)? = null

    class SelectCategoryViewHolder(val binding : ItemSelectCategoryBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(category: Category){
            binding.imageSelectCategory.setImageResource(category.image)
            binding.titleSelectCategory.text = category.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryViewHolder {
        val binding = ItemSelectCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SelectCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectCategoryViewHolder, position: Int) {

        holder.bind(category[position])

        holder.binding.root.setOnClickListener {
            onClickListener?.invoke(category[position])
            holder.binding.imageSelectCategory.backgroundTintList = ColorStateList.valueOf(Color.parseColor("#FF6E4E"))
            holder.binding.titleSelectCategory.setTextColor(ColorStateList.valueOf(Color.parseColor("#FF6E4E")))
        }
    }

    override fun getItemCount(): Int {
        return category.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListData(category : List<Category>) {
        this.category = category
        notifyDataSetChanged()
    }
}