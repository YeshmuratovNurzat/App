package com.etoolkit.myapp.data.network.home

import com.etoolkit.myapp.domain.home.model.ResultDataHome
import retrofit2.http.GET

interface HomeApiService {

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getBestSeller() : ResultDataHome

    @GET("654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHotSales() : ResultDataHome

}