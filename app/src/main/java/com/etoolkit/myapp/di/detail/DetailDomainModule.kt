package com.etoolkit.myapp.di.detail

import com.etoolkit.myapp.domain.detail.usecase.GetDataDetailUseCase
import org.koin.dsl.module

val detailDomainModule = module {

    factory<GetDataDetailUseCase> {
        GetDataDetailUseCase(repository = get())
    }

}