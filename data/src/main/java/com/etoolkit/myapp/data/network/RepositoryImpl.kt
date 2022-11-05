package com.etoolkit.myapp.data.network

import com.etoolkit.myapp.domain.model.ResultData
import com.etoolkit.myapp.domain.repository.Repository

class RepositoryImpl(private val service: ApiService) : Repository {

    override suspend fun getHotSales(): ResultData {
        return service.getHotSales()
    }

    override suspend fun getBestSeller(): ResultData {
        return service.getBestSeller()
    }
}