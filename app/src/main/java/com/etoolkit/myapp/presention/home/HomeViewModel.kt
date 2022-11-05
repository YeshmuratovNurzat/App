package com.etoolkit.myapp.presention.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.myapp.data.network.ApiFactory
import com.etoolkit.myapp.data.network.RepositoryImpl
import com.etoolkit.myapp.domain.model.ResultData
import com.etoolkit.myapp.domain.usecase.GetBestSellerUseCase
import com.etoolkit.myapp.domain.usecase.GetHotSalesUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository = RepositoryImpl(ApiFactory.apiService)

    private val getBestSellerUseCase = GetBestSellerUseCase(repository)
    private val getHotSalesUseCase = GetHotSalesUseCase(repository)

    private val _getHotSalesResult = MutableLiveData<ResultData>()
    val getHotSalesResult : LiveData<ResultData> get() = _getHotSalesResult

    private val _getBestSellerResult = MutableLiveData<ResultData>()
    val getBestSellerResult : LiveData<ResultData> get() = _getBestSellerResult

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