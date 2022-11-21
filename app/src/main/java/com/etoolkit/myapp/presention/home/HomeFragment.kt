package com.etoolkit.myapp.presention.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.FilterBottomSheetBinding
import com.etoolkit.myapp.databinding.FragmentHomeBinding
import com.etoolkit.myapp.domain.home.model.Category
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var navController: NavController

    private val category = listOf(
        Category("Phones", R.drawable.ic_phones),
        Category("Computer", R.drawable.ic_computer),
        Category("Health", R.drawable.ic_health),
        Category("Books", R.drawable.ic_books),
        Category("Computer", R.drawable.ic_computer),

    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapterSelectCategory = SelectCategoryAdapter()
        binding.categoryRecyclerView.adapter = adapterSelectCategory
        adapterSelectCategory.setListData(category)

        adapterSelectCategory.onClickListener = {
            Toast.makeText(requireContext(),it.title,Toast.LENGTH_SHORT).show()
        }

        val adapterHotSales = HotSalesAdapter()
        binding.hotSalesRecyclerView.adapter = adapterHotSales

        val adapterBestSeller = BestSellerAdapter()
        binding.bestSellerRecyclerView.adapter = adapterBestSeller
        binding.bestSellerRecyclerView.layoutManager = GridLayoutManager(requireContext(),2)

        adapterBestSeller.onClick = {
            navController.navigate(R.id.action_homeFragment_to_detailFragment)
        }

        viewModel.getHotSales()
        viewModel.getBestSeller()

        viewModel.getHotSalesResult.observe(viewLifecycleOwner){
            invisibleShimmer()
            Log.d("MyLog","getHotSalesResult = ${it.home_store}")
            adapterHotSales.setListData(it.home_store)
        }

        viewModel.getBestSellerResult.observe(viewLifecycleOwner){
            Log.d("MyLog","getBestSellerResult = ${it.best_seller}")
            adapterBestSeller.setListData(it.best_seller)
        }

        binding.filter.setOnClickListener {
            showBottomSheetDialog()
        }

    }

    private fun showBottomSheetDialog() {

        val bottomSheet = BottomSheetDialog(requireContext(), R.style.AppBottomSheetDialogTheme)
        bottomSheet.dismissWithAnimation = true
        bottomSheet.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        val binding = FilterBottomSheetBinding.inflate(layoutInflater)

        // btn back filter
        binding.back.setOnClickListener{
            bottomSheet.dismiss()
        }

        // btn done filter
        binding.btnDone.setOnClickListener {
            bottomSheet.dismiss()
        }

        //brand filter adapter
        val brands = resources.getStringArray(R.array.brands)
        val brandsAdapter = ArrayAdapter(requireContext(), R.layout.item_layout_filter, brands)
        binding.brand.setAdapter(brandsAdapter)

        //price filter adapter
        val prices = resources.getStringArray(R.array.prices)
        val pricesAdapter = ArrayAdapter(requireContext(), R.layout.item_layout_filter, prices)
        binding.price.setAdapter(pricesAdapter)

        //size filter adapter
        val sizes = resources.getStringArray(R.array.sizes)
        val sizesAdapter = ArrayAdapter(requireContext(), R.layout.item_layout_filter, sizes)
        binding.size.setAdapter(sizesAdapter)

        binding.brand.adapter

        bottomSheet.setCancelable(true)

        bottomSheet.setContentView(binding.root)

        bottomSheet.show()
    }

    // startShimmerAnimation()
    private fun visibilityShimmer(){
        binding.shimmerContainer.startShimmerAnimation()
        binding.shimmerContainer.visibility = View.VISIBLE
        binding.hotSalesRecyclerView.visibility = View.GONE
    }

    // stopShimmerAnimation
    private fun invisibleShimmer(){
        binding.shimmerContainer.stopShimmerAnimation()
        binding.shimmerContainer.visibility = View.INVISIBLE
        binding.hotSalesRecyclerView.visibility = View.VISIBLE
    }

    override fun onResume() {
        super.onResume()
        binding.shimmerContainer.startShimmerAnimation()
    }

    override fun onPause() {
        super.onPause()
        binding.shimmerContainer.stopShimmerAnimation()
    }

    companion object {

        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {}
        }
    }

}