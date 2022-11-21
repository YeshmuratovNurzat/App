package com.etoolkit.myapp.presention.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.myapp.data.network.home.HomeApiFactory
import com.etoolkit.myapp.data.network.home.HomeRepositoryImpl
import com.etoolkit.myapp.domain.home.model.ResultDataHome
import com.etoolkit.myapp.domain.home.repository.HomeRepository
import com.etoolkit.myapp.domain.home.usecase.GetBestSellerUseCase
import com.etoolkit.myapp.domain.home.usecase.GetHotSalesUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class HomeViewModel(private var repository: HomeRepository) : ViewModel() {

    private val getBestSellerUseCase = GetBestSellerUseCase(repository)
    private val getHotSalesUseCase = GetHotSalesUseCase(repository)

    private val _getHotSalesResult = MutableLiveData<ResultDataHome>()
    val getHotSalesResult : LiveData<ResultDataHome> get() = _getHotSalesResult

    private val _getBestSellerResult = MutableLiveData<ResultDataHome>()
    val getBestSellerResult : LiveData<ResultDataHome> get() = _getBestSellerResult


    fun getHotSales(){
        viewModelScope.launch {
            _getHotSalesResult.value = getHotSalesUseCase.invoke()
        }
    }

    fun getBestSeller(){
        viewModelScope.launch {
            _getBestSellerResult.value = getBestSellerUseCase.invoke()
        }
    }

}