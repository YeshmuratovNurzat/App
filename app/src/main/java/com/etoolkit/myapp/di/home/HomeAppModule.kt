package com.etoolkit.myapp.di

import com.etoolkit.myapp.presention.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeAppModule = module {

    viewModel<HomeViewModel>{
        HomeViewModel(repository = get())
    }

}