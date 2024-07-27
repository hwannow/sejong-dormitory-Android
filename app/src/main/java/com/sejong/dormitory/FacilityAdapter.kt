package com.sejong.dormitory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.databinding.FacilitySampleBinding

class FacilityAdapter(val List: ArrayList<FacilityData>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = FacilitySampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FacilityViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is FacilityViewHolder) {
            holder.title.text = List[position].title
            holder.date.text = List[position].date.toString()
            holder.writer.text = List[position].writer
            holder.reception.text = List[position].reception
        }
    }
}