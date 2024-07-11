package com.sejong.dormitory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sejong.dormitory.databinding.FragmentDietBinding

class DietFragment : Fragment() {
    private lateinit var binding:FragmentDietBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDietBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}