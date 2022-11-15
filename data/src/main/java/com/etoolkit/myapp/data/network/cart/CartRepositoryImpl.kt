package com.etoolkit.myapp.data.network.cart

import com.etoolkit.myapp.domain.cart.model.CartResultData
import com.etoolkit.myapp.domain.cart.repository.CartRepository

class CartRepositoryImpl(private val service: CartApiService) : CartRepository {

    override suspend fun getCardData(): CartResultData {
        return service.getCardData()
    }
}