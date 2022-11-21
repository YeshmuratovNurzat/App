package com.etoolkit.myapp.presention.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etoolkit.myapp.data.network.detail.DetailApiFactory
import com.etoolkit.myapp.data.network.detail.DetailRepositoryImpl
import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail
import com.etoolkit.myapp.domain.detail.repository.DetailRepository
import com.etoolkit.myapp.domain.detail.usecase.GetDataDetailUseCase
import kotlinx.coroutines.launch

class DetailViewModel(private var repository: DetailRepository) : ViewModel() {

    private val getDataDetailUseCase = GetDataDetailUseCase(repository)

    private val _getDataDetailResult = MutableLiveData<DataResult>()
    val getDataDetailResult : LiveData<DataResult> get() = _getDataDetailResult

    fun getDataDetail() {
        viewModelScope.launch {
            _getDataDetailResult.value = getDataDetailUseCase.invoke()
        }
    }
}