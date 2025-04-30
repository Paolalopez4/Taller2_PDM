package com.pdmtaller2.PaolaLopez_00167523.data

import androidx.annotation.DrawableRes

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int,
    val categories: List<String>,
    val menu: List<Dish>,
)