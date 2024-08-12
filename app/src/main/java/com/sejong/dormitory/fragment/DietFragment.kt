package com.sejong.dormitory.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.google.android.material.tabs.TabLayoutMediator
import com.sejong.dormitory.DietViewModel
import com.sejong.dormitory.RetrofitClient
import com.sejong.dormitory.ViewPagerAdapter
import com.sejong.dormitory.data.DietData
import com.sejong.dormitory.databinding.FragmentDietBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DietFragment : Fragment() {
    private lateinit var binding:FragmentDietBinding
    private lateinit var dietViewModel: DietViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDietBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 뷰모델 생성
        dietViewModel = ViewModelProvider(this).get(DietViewModel::class.java)

        dietViewModel.menuList.observe(viewLifecycleOwner, Observer { menuList ->
            val viewPagerAdapter = ViewPagerAdapter(this, menuList)
            binding.viewPager.adapter = viewPagerAdapter

            TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
                tab.text = getTabTitle(position)
            }.attach()
        })
    }

    private fun getTabTitle(position: Int): String {
        return when (position) {
            0 -> "월"
            1 -> "화"
            2 -> "수"
            3 -> "목"
            4 -> "금"
            5 -> "토"
            6 -> "일"
            else -> "월"
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.viewPager.adapter = null
    }
}