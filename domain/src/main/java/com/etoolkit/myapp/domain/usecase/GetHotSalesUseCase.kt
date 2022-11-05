package com.etoolkit.myapp.domain.usecase

import com.etoolkit.myapp.domain.model.ResultData
import com.etoolkit.myapp.domain.repository.Repository

class GetHotSalesUseCase(private val repository: Repository) {

    suspend fun invoke() : ResultData {
        return repository.getHotSales()
    }
}