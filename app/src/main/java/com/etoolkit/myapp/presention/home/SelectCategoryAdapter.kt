package com.etoolkit.myapp.presention.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.ItemSelectCategoryBinding

class SelectCategoryAdapter : RecyclerView.Adapter<SelectCategoryAdapter.SelectCategoryViewHolder>() {

    val listImage = listOf(
        R.drawable.ic_phone,
        R.drawable.ic_computer,
        R.drawable.ic_health,
        R.drawable.ic_books,
        R.drawable.ic_computer,
    )

    val listTitle = listOf(
        "Phone",
        "Computer",
        "Health",
        "Books",
        "Computer")

    var shopOnClickListener: (() -> Unit)? = null


    class SelectCategoryViewHolder(val binding : ItemSelectCategoryBinding) : RecyclerView.ViewHolder(binding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SelectCategoryViewHolder {
        val binding = ItemSelectCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return SelectCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SelectCategoryViewHolder, position: Int) {
        holder.binding.imageSelectCategory.setImageResource(listImage[position])
        holder.binding.titleSelectCategory.text = listTitle[position]

        holder.binding.root.setOnClickListener {
            shopOnClickListener?.invoke()
        }
    }

    override fun getItemCount(): Int {
        return listImage.size
    }
}