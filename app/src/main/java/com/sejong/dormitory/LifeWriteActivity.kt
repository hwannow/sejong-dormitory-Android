package com.sejong.dormitory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sejong.dormitory.databinding.ActivityLifeWriteBinding

class LifeWriteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityLifeWriteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeWriteBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}