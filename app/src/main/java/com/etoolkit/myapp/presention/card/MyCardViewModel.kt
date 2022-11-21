package com.etoolkit.myapp.presention.card

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.myapp.data.network.card.CardApiFactory
import com.etoolkit.myapp.data.network.card.CardRepositoryImpl
import com.etoolkit.myapp.domain.card.model.CardResultData
import com.etoolkit.myapp.domain.card.repository.CardRepository
import com.etoolkit.myapp.domain.card.usecase.GetCardDataUseCase
import kotlinx.coroutines.launch

class MyCardViewModel(private var repository: CardRepository) : ViewModel() {

    private val getCartDataUseCase = GetCardDataUseCase(repository)

    private val _getCartDataResult = MutableLiveData<CardResultData>()
    val getCartDataResult : LiveData<CardResultData> get() = _getCartDataResult

    fun getCartData() {
        viewModelScope.launch {
            _getCartDataResult.value = getCartDataUseCase.invoke()
        }
    }
}