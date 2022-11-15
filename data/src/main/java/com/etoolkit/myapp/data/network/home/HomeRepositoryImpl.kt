package com.etoolkit.myapp.data.network.home

import com.etoolkit.myapp.domain.home.model.ResultDataHome
import com.etoolkit.myapp.domain.home.repository.HomeRepository

class HomeRepositoryImpl(private val service: HomeApiService) : HomeRepository {

    override suspend fun getHotSales(): ResultDataHome {
        return service.getHotSales()
    }

    override suspend fun getBestSeller(): ResultDataHome {
        return service.getBestSeller()
    }
}