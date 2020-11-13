package com.example.mymaterialdesign.adapter

import  com.example.mymaterialdesign.model.ProductModel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mymaterialdesign.databinding.ItemProductBinding



class AdapterProduct(private val context: Context) :
    RecyclerView.Adapter<AdapterProduct.ViewHolder>() {

    private var products = listOf<ProductModel>()

    fun setData(data: List<ProductModel>) {
        products = data
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemProductBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun binData(product: ProductModel) {
            binding.tvProduct.text = product.title
            binding.tvPrice.text = "$${product.price}"
            Glide.with(binding.root).load(product.imageUrl).into(binding.ivProduct)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        return ViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binData(products[position])
    }

    override fun getItemCount(): Int = products.size
}


