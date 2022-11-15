package com.etoolkit.myapp.domain.cart.model

data class CartResultData(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)