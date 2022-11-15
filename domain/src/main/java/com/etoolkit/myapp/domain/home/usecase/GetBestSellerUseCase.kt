package com.etoolkit.myapp.domain.home.usecase

import com.etoolkit.myapp.domain.home.model.ResultDataHome
import com.etoolkit.myapp.domain.home.repository.HomeRepository

class GetBestSellerUseCase(private val repository: HomeRepository) {

    suspend fun invoke() : ResultDataHome {
        return repository.getBestSeller()
    }
}