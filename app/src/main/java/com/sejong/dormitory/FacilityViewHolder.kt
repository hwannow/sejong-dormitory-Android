package com.sejong.dormitory

import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.databinding.FacilitySampleBinding
import com.sejong.dormitory.databinding.LifeSampleBinding

class FacilityViewHolder(binding: FacilitySampleBinding): RecyclerView.ViewHolder(binding.root) {
    val title = binding.tvTitle
    val writer = binding.tvWriter
    val date = binding.tvDate
    val reception = binding.tvReception
}