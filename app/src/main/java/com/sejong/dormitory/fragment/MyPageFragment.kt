package com.sejong.dormitory.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sejong.dormitory.activity.ScoreActivity
import com.sejong.dormitory.databinding.FragmentMyPageBinding

class MyPageFragment : Fragment() {
    private lateinit var binding:FragmentMyPageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyPageBinding.inflate(layoutInflater, container, false)

        binding.tvScore.setOnClickListener{
            val intent = Intent(context, ScoreActivity::class.java)
            startActivity(intent)
        }

        binding.tvHomePage.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://happydorm.sejong.ac.kr/"))
            startActivity(intent)
        }

        return binding.root
    }
}