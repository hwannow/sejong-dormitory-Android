package com.sejong.dormitory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.data.MainData
import com.sejong.dormitory.databinding.MainSampleBinding

class MainAdapter(val List: ArrayList<MainData>):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = MainSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is MainViewHolder) {
            holder.title.text = List[position].title
            holder.date.text = List[position].date.toString()
            holder.writer.text = List[position].writer
        }
    }
}