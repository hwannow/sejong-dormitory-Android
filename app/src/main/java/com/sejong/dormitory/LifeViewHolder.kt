package com.sejong.dormitory

import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.databinding.LifeSampleBinding
import com.sejong.dormitory.databinding.MainSampleBinding

class LifeViewHolder(binding: LifeSampleBinding): RecyclerView.ViewHolder(binding.root) {
    val title = binding.tvTitle
    val writer = binding.tvWriter
    val date = binding.tvDate
    val secret = binding.tvSecret
}