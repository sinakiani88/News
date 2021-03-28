package com.example.news.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news.databinding.NewsItemViewBinding

class BreakingNewsAdapter constructor():RecyclerView.Adapter<BreakingNewsAdapter.BreakingNewsViewHolder>() {

    inner class BreakingNewsViewHolder(private val newsItemViewBinding: NewsItemViewBinding):RecyclerView.ViewHolder(newsItemViewBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BreakingNewsViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: BreakingNewsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}