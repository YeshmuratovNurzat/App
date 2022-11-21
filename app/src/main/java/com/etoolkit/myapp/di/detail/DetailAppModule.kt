package com.etoolkit.myapp.di.detail

import com.etoolkit.myapp.presention.detail.DetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val detailAppModule = module {

    viewModel<DetailViewModel>{
        DetailViewModel(repository = get())
    }

}