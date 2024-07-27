package com.sejong.dormitory

import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.databinding.MainSampleBinding

class MainViewHolder(binding:MainSampleBinding):RecyclerView.ViewHolder(binding.root) {
    val writer = binding.tvWriter
    val date = binding.tvDate
    val title = binding.tvTitle
}