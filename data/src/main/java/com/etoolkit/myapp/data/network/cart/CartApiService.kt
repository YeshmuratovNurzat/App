package com.etoolkit.myapp.data.network.cart

import com.etoolkit.myapp.domain.cart.model.CartResultData
import retrofit2.http.GET

interface CartApiService {

    @GET("53539a72-3c5f-4f30-bbb1-6ca10d42c149")
    suspend fun getCardData() : CartResultData

}