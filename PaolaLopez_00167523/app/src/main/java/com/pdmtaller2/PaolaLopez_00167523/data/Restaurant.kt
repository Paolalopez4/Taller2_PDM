package com.pdmtaller2.PaolaLopez_00167523.data

data class Restaurant(
    val id: Int,
    val name: String,
    val description: String,
    val imageURL: String,
    val categories: List<String>,
    val menu: List<Dish>,
)