package com.sejong.dormitory

import java.time.LocalDate

//제목, 작성자, 작성일, 번호, 접수 상태
data class FacilityData(
    val title: String,
    val writer: String,
    val date: LocalDate,
    val boardNum: Int,
    val reception: String
)
