package com.sejong.dormitory.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sejong.dormitory.fragment.DialogFragment
import com.sejong.dormitory.databinding.ActivityComplaintsBinding

class ComplaintsActivity : AppCompatActivity(), DialogFragment.TitleUpdateListener {
    private lateinit var binding:ActivityComplaintsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComplaintsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBack.setOnClickListener {
            finish()
        }

        binding.btnChoose.setOnClickListener {
            val bottomSheet = DialogFragment()
            bottomSheet.show(supportFragmentManager, bottomSheet.tag)
        }
    }

    override fun onTextUpdate(newText: String) {
        binding.tvTitle.text = newText
    }
}