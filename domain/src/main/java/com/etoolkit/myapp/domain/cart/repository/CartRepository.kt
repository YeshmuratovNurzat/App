package com.etoolkit.myapp.domain.cart.repository

import com.etoolkit.myapp.domain.cart.model.CartResultData

interface CartRepository {

    suspend fun getCardData() : CartResultData

}