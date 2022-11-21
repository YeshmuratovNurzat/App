package com.etoolkit.myapp.di.card

import com.etoolkit.myapp.presention.card.MyCardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val cardAppModule = module {

    viewModel<MyCardViewModel> {
        MyCardViewModel(repository = get())
    }

}