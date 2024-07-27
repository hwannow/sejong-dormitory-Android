package com.sejong.dormitory


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sejong.dormitory.databinding.ActivityFacilityWriteBinding

class FacilityWriteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFacilityWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFacilityWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}