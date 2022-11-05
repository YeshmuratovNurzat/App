package com.etoolkit.myapp.presention.home

import android.content.res.ColorStateList
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.constraintlayout.utils.widget.ImageFilterView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterSelectCategory = SelectCategoryAdapter()
        binding.categoryRecyclerView.adapter = adapterSelectCategory

        val adapterHotSales = HotSalesAdapter()
        binding.hotSalesRecyclerView.adapter = adapterHotSales

        val adapterBestSeller = BestSellerAdapter()
        binding.bestSellerRecyclerView.adapter = adapterBestSeller
        binding.bestSellerRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        viewModel.getHotSales()
        viewModel.getBestSeller()

        viewModel.getHotSalesResult.observe(viewLifecycleOwner){
            Log.d("MyLog","getHotSalesResult = ${it.home_store}")
            adapterHotSales.setListData(it.home_store)
        }

        viewModel.getBestSellerResult.observe(viewLifecycleOwner){
            Log.d("MyLog","getBestSellerResult = ${it.home_store}")
            adapterBestSeller.setListData(it.best_seller)
        }

    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun ImageFilterView.tabSelected() {
        imageTintList = ColorStateList.valueOf(context.getColor(R.color.tab_selected_active))
        backgroundTintList = ColorStateList.valueOf(context.getColor(R.color.tab_selected_inactive))
        if (id == R.id.image_select_category){
            // next fragment
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun List<View>.allTabsUnselect() {
        map {
            if (it is ImageFilterView) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    it.backgroundTintList =
                        ColorStateList.valueOf(requireContext().getColor(R.color.select_category_background))
                }
                it.imageTintList = ColorStateList.valueOf(requireContext().getColor(R.color.white))
            }
        }
    }


    companion object {

        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {}
        }
    }

}