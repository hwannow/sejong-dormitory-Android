package com.sejong.dormitory.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejong.dormitory.FacilityAdapter
import com.sejong.dormitory.FacilityData
import com.sejong.dormitory.LifeAdapter
import com.sejong.dormitory.LifeData
import com.sejong.dormitory.fragment.DialogFragment
import com.sejong.dormitory.databinding.ActivityComplaintsBinding
import java.time.LocalDate

class ComplaintsActivity : AppCompatActivity(), DialogFragment.TitleUpdateListener, DialogFragment.AdapterUpdateListener {
    private lateinit var binding:ActivityComplaintsBinding
    private lateinit var lifeAdapter: LifeAdapter
    private lateinit var facilityAdapter: FacilityAdapter

    @RequiresApi(Build.VERSION_CODES.O)
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

        val LifeList = ArrayList<LifeData>()
        val FacilityList = ArrayList<FacilityData>()


        LifeList.add(
            LifeData(
                "안녕하세요",
                "김은지",
                LocalDate.now(),
                123,
                "공개"
            )
        )

        FacilityList.add(
            FacilityData(
                "힘들어요",
                "박근경",
                LocalDate.now(),
                123,
                "처리 중"
            )
        )

        lifeAdapter = LifeAdapter(LifeList)
        facilityAdapter = FacilityAdapter(FacilityList)

        binding.rcv.adapter = facilityAdapter
        binding.rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }

    override fun onTextUpdate(newText: String) {
        binding.tvTitle.text = newText
    }

    override fun onFacilityAdapterUpdate() {
        binding.rcv.adapter = facilityAdapter
    }

    override fun onLifeAdapterUpdate() {
        binding.rcv.adapter = lifeAdapter
    }
}