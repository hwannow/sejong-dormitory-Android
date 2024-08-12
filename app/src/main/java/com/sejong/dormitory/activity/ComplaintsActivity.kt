package com.sejong.dormitory.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.sejong.dormitory.FacilityAdapter
import com.sejong.dormitory.data.FacilityData
import com.sejong.dormitory.FacilityWriteActivity
import com.sejong.dormitory.LifeAdapter
import com.sejong.dormitory.data.LifeData
import com.sejong.dormitory.LifeWriteActivity
import com.sejong.dormitory.fragment.DialogFragment
import com.sejong.dormitory.databinding.ActivityComplaintsBinding
import java.time.LocalDate

class ComplaintsActivity : AppCompatActivity(), DialogFragment.TitleUpdateListener, DialogFragment.AdapterUpdateListener {
    private lateinit var binding:ActivityComplaintsBinding
    private lateinit var lifeAdapter: LifeAdapter
    private lateinit var facilityAdapter: FacilityAdapter
    // 시설 민원일 경우 1
    // 생활 민원일 경우 0
    private var complaints: Int = 1

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

        val lifeList = ArrayList<LifeData>()
        val facilityList = ArrayList<FacilityData>()


        lifeList.add(
            LifeData(
                "안녕하세요",
                "김은지",
                LocalDate.now(),
                123,
                "공개"
            )
        )

        lifeList.add(
            LifeData(
                "안녕하세요",
                "김은지",
                LocalDate.now(),
                123,
                "비공개"
            )
        )

        facilityList.add(
            FacilityData(
                "힘들어요",
                "박근경",
                LocalDate.now(),
                123,
                "처리 중"
            )
        )

        facilityList.add(
            FacilityData(
                "힘들어요",
                "박근경",
                LocalDate.now(),
                123,
                "처리 완료"
            )
        )

        lifeAdapter = LifeAdapter(lifeList)
        facilityAdapter = FacilityAdapter(facilityList)

        binding.rcv.adapter = facilityAdapter
        binding.rcv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


        binding.btnWrite.setOnClickListener {
            if (complaints == 1) {
                val intent = Intent(this, FacilityWriteActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(this, LifeWriteActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onTextUpdate(newText: String) {
        binding.tvTitle.text = newText
    }

    override fun onFacilityAdapterUpdate() {
        binding.rcv.adapter = facilityAdapter
        complaints = 1
    }

    override fun onLifeAdapterUpdate() {
        binding.rcv.adapter = lifeAdapter
        complaints = 0
    }
}