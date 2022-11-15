package com.etoolkit.myapp.domain.cart.usecase

import com.etoolkit.myapp.domain.cart.model.CartResultData
import com.etoolkit.myapp.domain.cart.repository.CartRepository

class GetCartDataUseCase(private val repository: CartRepository) {

    suspend fun invoke() : CartResultData {
        return repository.getCardData()
    }
}