package com.sejong.dormitory

import android.app.Activity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sejong.dormitory.databinding.ActivityComplaintsBinding

class ComplaintsActivity : AppCompatActivity() {
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
}