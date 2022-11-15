package com.etoolkit.myapp.data.network.detail

import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail
import com.etoolkit.myapp.domain.detail.repository.DetailRepository

class DetailRepositoryImpl(private val service: DetailApiService) : DetailRepository{

    override suspend fun getDataDetail(): DataResult {
        return service.getDataDetail()
    }

}