package com.etoolkit.myapp.di

import com.etoolkit.myapp.domain.home.usecase.GetBestSellerUseCase
import com.etoolkit.myapp.domain.home.usecase.GetHotSalesUseCase
import org.koin.dsl.module


val homeDomainModule = module {

    factory<GetBestSellerUseCase> {
        GetBestSellerUseCase(repository = get())
    }

    factory<GetHotSalesUseCase> {
        GetHotSalesUseCase(repository = get())
    }


}