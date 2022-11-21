package com.etoolkit.myapp.data.network.card

import com.etoolkit.myapp.domain.card.model.CardResultData
import com.etoolkit.myapp.domain.card.repository.CardRepository

class CardRepositoryImpl(private val service: CardApiService) : CardRepository {

    override suspend fun getCardData(): CardResultData {
        return service.getCardData()
    }
}