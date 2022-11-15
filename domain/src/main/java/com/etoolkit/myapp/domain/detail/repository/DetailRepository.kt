package com.etoolkit.myapp.domain.detail.repository

import com.etoolkit.myapp.domain.detail.model.DataResult
import com.etoolkit.myapp.domain.detail.model.ResultDataDetail

interface DetailRepository {

    suspend fun getDataDetail() : DataResult
}