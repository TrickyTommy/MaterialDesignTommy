package com.example.mymaterialdesign.adapter

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mymaterialdesign.model.ProductModel

class AdapterProduct (private val context: Context, private val items: List<ProductModel>): RecyclerView.Adapter<AdapterProduct.ProductViewHolder>(){

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterProduct.ProductViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
    inner class ProductViewHolder {

    }
}
