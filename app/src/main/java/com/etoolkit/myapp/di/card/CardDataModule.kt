package com.etoolkit.myapp.di.card

import com.etoolkit.myapp.data.network.card.CardApiFactory
import com.etoolkit.myapp.data.network.card.CardApiService
import com.etoolkit.myapp.data.network.card.CardRepositoryImpl
import com.etoolkit.myapp.domain.card.repository.CardRepository
import org.koin.dsl.module

val cardDataModule = module {

    single<CardApiService> {
        CardApiFactory.cartApiService
    }

    single<CardRepository>{
        CardRepositoryImpl(service = get())
    }
}