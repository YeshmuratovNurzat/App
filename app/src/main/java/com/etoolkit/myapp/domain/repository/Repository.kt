package com.etoolkit.myapp.domain.repository

import com.etoolkit.myapp.domain.model.ResultData

interface Repository {

    suspend fun getHotSales() : ResultData

    suspend fun getBestSeller() : ResultData
}