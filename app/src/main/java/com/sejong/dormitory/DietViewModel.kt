package com.sejong.dormitory


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sejong.dormitory.data.DietData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DietViewModel: ViewModel() {

    private val _menuList = MutableLiveData<MutableList<DietData>>()
    val defaultDietData = DietData(0, "date", "", "")
    val dietList = MutableList(7) { defaultDietData }

    val menuList: MutableLiveData<MutableList<DietData>>
        get() = _menuList

    init {
        RetrofitClient.instance.getMenu().enqueue(object: Callback<MutableList<DietData>> {
            override fun onResponse(
                call: Call<MutableList<DietData>>,
                response: Response<MutableList<DietData>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    _menuList.value = response.body()!!
                } else {
                    //Toast.makeText(context, "실패", Toast.LENGTH_SHORT).show()
                    _menuList.value = dietList
                }
            }

            // 실패
            override fun onFailure(call: Call<MutableList<DietData>>, t: Throwable) {
                //Toast.makeText(context, "실패", Toast.LENGTH_SHORT).show()
            }
        })
    }
}