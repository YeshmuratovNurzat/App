package com.etoolkit.myapp.data.network.card

import com.etoolkit.myapp.domain.card.model.CardResultData
import retrofit2.http.GET

interface CardApiService {

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCardData() : CardResultData

}