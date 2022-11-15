package com.etoolkit.myapp.data.network.detail

import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail
import retrofit2.http.GET

interface DetailApiService {

    @GET("6c14c560-15c6-4248-b9d2-b4508df7d4f5")
    suspend fun getDataDetail() : DataResult
}