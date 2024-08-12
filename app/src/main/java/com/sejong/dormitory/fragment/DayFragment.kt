package com.sejong.dormitory.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sejong.dormitory.data.DietData
import com.sejong.dormitory.databinding.FragmentDayBinding

class DayFragment : Fragment() {
    private lateinit var binding:FragmentDayBinding

    companion object {
        private const val ARG_DATE = "arg_date"
        private const val ARG_LUNCH = "arg_lunch"
        private const val ARG_DINNER = "arg_dinner"

        fun newInstance(menu: DietData): DayFragment {
            val fragment = DayFragment()
            val bundle = Bundle()
            bundle.putString(ARG_DATE, menu.date)
            bundle.putString(ARG_LUNCH, menu.lunch)
            bundle.putString(ARG_DINNER, menu.dinner)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDayBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val date = arguments?.getString(ARG_DATE) ?: ""
        var lunch = arguments?.getString(ARG_LUNCH) ?: ""
        var dinner = arguments?.getString(ARG_DINNER) ?: ""

        if (lunch == "") lunch = "식단이 등록되지 않았습니다."
        if (dinner == "") dinner = "식단이 등록되지 않았습니다."

        binding.tvDay.text = date
        binding.tvLunch.text = lunch
        binding.tvDinner.text = dinner
    }

}