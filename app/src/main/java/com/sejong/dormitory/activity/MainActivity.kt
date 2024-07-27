package com.sejong.dormitory.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sejong.dormitory.fragment.DietFragment
import com.sejong.dormitory.fragment.MainFragment
import com.sejong.dormitory.fragment.MyPageFragment
import com.sejong.dormitory.R
import com.sejong.dormitory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mainFragment = MainFragment()
        val dietFragment = DietFragment()
        val myPageFragment = MyPageFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.fcv_fragment, mainFragment).commit()

        binding.bottomnav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.main -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_fragment, mainFragment).commit()
                    true
                }

                R.id.complaints -> {
                    binding.bottomnav.selectedItemId = R.id.main
                    val intent = Intent(this, ComplaintsActivity::class.java)
                    startActivity(intent)
                    binding.bottomnav.invalidate()
                    true
                }

                R.id.diet -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_fragment, dietFragment).commit()
                    true
                }

                R.id.myPage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fcv_fragment, myPageFragment).commit()
                    true
                }

                else -> false
            }
        }

        binding.bottomnav.selectedItemId = R.id.main
    }
}