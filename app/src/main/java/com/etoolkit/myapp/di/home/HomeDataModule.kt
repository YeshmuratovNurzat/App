package com.etoolkit.myapp.di

import com.etoolkit.myapp.data.network.home.HomeApiFactory
import com.etoolkit.myapp.data.network.home.HomeApiService
import com.etoolkit.myapp.data.network.home.HomeRepositoryImpl
import com.etoolkit.myapp.domain.home.repository.HomeRepository
import org.koin.dsl.module

val homeDataModule = module {

    single<HomeApiService> {
        HomeApiFactory.homeApiService
    }

    single<HomeRepository> {
        HomeRepositoryImpl(service = get())
    }

}