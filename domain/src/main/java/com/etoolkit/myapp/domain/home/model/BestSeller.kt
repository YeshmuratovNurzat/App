package com.etoolkit.myapp.domain.home.model

import java.io.Serializable

data class BestSeller(
    val discount_price: Int,
    val id: Int,
    val is_favorites: Boolean,
    val picture: String,
    val price_without_discount: Int,
    val title: String
) : Serializable