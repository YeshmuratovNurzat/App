package com.etoolkit.myapp.presention.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.myapp.data.network.cart.CartApiFactory
import com.etoolkit.myapp.data.network.cart.CartRepositoryImpl
import com.etoolkit.myapp.domain.cart.model.CartResultData
import com.etoolkit.myapp.domain.cart.usecase.GetCartDataUseCase
import kotlinx.coroutines.launch

class MyCardViewModel : ViewModel() {

    private val repository = CartRepositoryImpl(CartApiFactory.cartApiService)

    private val getCartDataUseCase = GetCartDataUseCase(repository)

    private val _getCartDataResult = MutableLiveData<CartResultData>()
    val getCartDataResult : LiveData<CartResultData> get() = _getCartDataResult

    fun getCartData() {
        viewModelScope.launch {
            _getCartDataResult.value = getCartDataUseCase.invoke()
        }
    }
}