package com.sejong.dormitory

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sejong.dormitory.data.LifeData
import com.sejong.dormitory.databinding.LifeSampleBinding

class LifeAdapter(val List: ArrayList<LifeData>): RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = LifeSampleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LifeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return List.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is LifeViewHolder) {
            holder.title.text = List[position].title
            holder.date.text = List[position].date.toString()
            holder.writer.text = List[position].writer
            holder.secret.text = List[position].secret

            holder.secret.isSelected = (List[position].secret == "비공개")
        }
    }

}