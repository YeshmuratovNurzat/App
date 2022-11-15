package com.etoolkit.myapp.domain.detail.usecase

import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail
import com.etoolkit.myapp.domain.detail.repository.DetailRepository

class GetDataDetailUseCase(private val repository: DetailRepository) {

    suspend fun invoke() : DataResult {
        return repository.getDataDetail()
    }
}