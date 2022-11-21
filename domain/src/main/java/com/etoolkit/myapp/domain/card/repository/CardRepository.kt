package com.etoolkit.myapp.domain.card.repository

import com.etoolkit.myapp.domain.card.model.CardResultData

interface CardRepository {

    suspend fun getCardData() : CardResultData

}