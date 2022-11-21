package com.etoolkit.myapp.app

import android.app.Application
import com.etoolkit.myapp.di.*
import com.etoolkit.myapp.di.card.cardAppModule
import com.etoolkit.myapp.di.card.cardDataModule
import com.etoolkit.myapp.di.card.cardDomainModule
import com.etoolkit.myapp.di.detail.detailAppModule
import com.etoolkit.myapp.di.detail.detailDataModule
import com.etoolkit.myapp.di.detail.detailDomainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@App)
            modules(listOf(
                homeAppModule, homeDomainModule, homeDataModule,
                detailAppModule, detailDomainModule, detailDataModule,
                cardAppModule, cardDomainModule, cardDataModule))
        }
    }
}