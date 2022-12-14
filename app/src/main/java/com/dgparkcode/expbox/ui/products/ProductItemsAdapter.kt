/*
 * Copyright (c) 2022. dgparkcode. All rights reserved.
 */

package com.dgparkcode.expbox.ui.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dgparkcode.expbox.R
import com.dgparkcode.expbox.databinding.ItemProductBinding

class ProductItemsAdapter : ListAdapter<ProductItemUiState, ProductItemsAdapter.ProductViewHolder>(ProductComparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = DataBindingUtil.inflate<ItemProductBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_product,
            parent,
            false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(productItem: ProductItemUiState) {
            binding.apply { this.productItem = productItem }
        }
    }

    object ProductComparator : DiffUtil.ItemCallback<ProductItemUiState>() {

        override fun areItemsTheSame(oldItem: ProductItemUiState, newItem: ProductItemUiState): Boolean {
            return oldItem.product.id == newItem.product.id
        }

        override fun areContentsTheSame(oldItem: ProductItemUiState, newItem: ProductItemUiState): Boolean {
            return oldItem.product == newItem.product
        }
    }
}