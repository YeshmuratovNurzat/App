package com.etoolkit.myapp.di.detail

import com.etoolkit.myapp.data.network.detail.DetailApiFactory
import com.etoolkit.myapp.data.network.detail.DetailApiService
import com.etoolkit.myapp.data.network.detail.DetailRepositoryImpl
import com.etoolkit.myapp.domain.detail.repository.DetailRepository
import org.koin.dsl.module


val detailDataModule = module {

    single<DetailApiService> {
        DetailApiFactory.detailApiService
    }

    single<DetailRepository> {
        DetailRepositoryImpl(service = get())
    }

}