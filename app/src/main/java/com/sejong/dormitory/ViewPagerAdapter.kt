package com.sejong.dormitory

import android.annotation.SuppressLint
import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sejong.dormitory.data.DietData
import com.sejong.dormitory.fragment.DayFragment

class ViewPagerAdapter(fragment: Fragment, private var menuList: MutableList<DietData>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = menuList.size

    override fun createFragment(position: Int): Fragment {
        return DayFragment.newInstance(menuList[position])
    }


}