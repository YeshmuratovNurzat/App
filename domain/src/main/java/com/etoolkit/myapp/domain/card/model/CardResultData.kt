package com.etoolkit.myapp.domain.card.model

data class CardResultData(
    val basket: List<Basket>,
    val delivery: String,
    val id: String,
    val total: Int
)