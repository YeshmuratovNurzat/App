package com.etoolkit.myapp.domain.home.repository

import com.etoolkit.myapp.domain.home.model.ResultDataHome

interface HomeRepository {

    suspend fun getHotSales() : ResultDataHome

    suspend fun getBestSeller() : ResultDataHome


}