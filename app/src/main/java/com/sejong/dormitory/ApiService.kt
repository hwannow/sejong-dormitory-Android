package com.sejong.dormitory

import com.sejong.dormitory.data.DietData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("menu")
    fun getMenu (

    ): Call<MutableList<DietData>>
}