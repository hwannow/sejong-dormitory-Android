package com.sejong.dormitory.fragment

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejong.dormitory.MainAdapter
import com.sejong.dormitory.MainData
import com.sejong.dormitory.databinding.FragmentMainBinding
import java.time.LocalDate

class MainFragment : Fragment() {
    private lateinit var binding:FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val List = ArrayList<MainData>()

        // dummy data
        List.add(
            MainData(
                "환노",
                LocalDate.now(),
                "안녕하세요"
            )
        )

        List.add(
            MainData(
                "내에임트레쉬",
                LocalDate.now(),
                "하 힘들다!!!"
            )
        )

        binding.rcv.adapter = MainAdapter(List)
        binding.rcv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }
}