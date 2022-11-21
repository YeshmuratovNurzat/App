package com.etoolkit.myapp.domain.card.usecase

import com.etoolkit.myapp.domain.card.model.CardResultData
import com.etoolkit.myapp.domain.card.repository.CardRepository

class GetCardDataUseCase(private val repository: CardRepository) {

    suspend fun invoke() : CardResultData {
        return repository.getCardData()
    }
}