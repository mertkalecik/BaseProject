package com.base.mert.ing.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.base.mert.ing.R
import com.base.mert.ing.databinding.ItemRepoBinding
import com.base.mert.ing.ui.data.home.RepoEntity

class RepoAdapter(
        private val mutableList: MutableList<RepoEntity>
) :RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = DataBindingUtil.inflate<ItemRepoBinding>(
                LayoutInflater.from(parent.context),
                viewType,
                parent,
                false
        )
        return RepoViewHolder(binding)
    }
    override fun getItemCount(): Int = mutableList.size

    override fun getItemViewType(position: Int): Int = R.layout.item_repo

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) = holder.bind()

    inner class RepoViewHolder(val binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind() {
            binding.executePendingBindings()
            binding.data = mutableList[adapterPosition]
        }
    }
}