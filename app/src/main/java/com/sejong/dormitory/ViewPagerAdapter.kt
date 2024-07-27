package com.sejong.dormitory

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.sejong.dormitory.fragment.DayFragment

class ViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    private val daysOfWeek = listOf(
        "Monday" to "Monday's Schedule",
        "Tuesday" to "Tuesday's Schedule",
        "Wednesday" to "Wednesday's Schedule",
        "Thursday" to "Thursday's Schedule",
        "Friday" to "Friday's Schedule",
        "Saturday" to "Saturday's Schedule",
        "Sunday" to "Sunday's Schedule"
    )

    override fun getItemCount(): Int = daysOfWeek.size

    override fun createFragment(position: Int): Fragment {
        val (title, content) = daysOfWeek[position]
        return DayFragment.newInstance(title, content)
    }
}