package com.etoolkit.myapp.di.card

import com.etoolkit.myapp.domain.card.usecase.GetCardDataUseCase
import org.koin.dsl.module

val cardDomainModule = module {

    factory<GetCardDataUseCase> {
        GetCardDataUseCase(repository = get())
    }
}