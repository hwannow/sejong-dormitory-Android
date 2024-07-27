package com.sejong.dormitory

import java.time.LocalDate

data class LifeData(
    val title: String,
    val writer: String,
    val date: LocalDate,
    val boardNum: Int,
    val secret: String
)