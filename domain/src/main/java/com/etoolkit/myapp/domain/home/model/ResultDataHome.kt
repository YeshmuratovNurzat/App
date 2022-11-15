package com.etoolkit.myapp.domain.home.model

data class ResultDataHome(
    val best_seller: List<BestSeller>,
    val home_store: List<HomeStore>
)