package com.etoolkit.myapp.data.network

import com.etoolkit.myapp.domain.model.ResultData
import retrofit2.http.GET

interface ApiService {

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getBestSeller() : ResultData

    @GET("v3/654bd15e-b121-49ba-a588-960956b15175")
    suspend fun getHotSales() : ResultData

}