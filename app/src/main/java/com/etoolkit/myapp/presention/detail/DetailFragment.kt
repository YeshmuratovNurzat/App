package com.etoolkit.myapp.presention.detail

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.FragmentDetailBinding
import com.etoolkit.myapp.presention.util.ZoomCenterCardLayoutManager
import com.google.android.material.tabs.TabLayoutMediator
import com.mig35.carousellayoutmanager.CenterScrollListener

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private lateinit var navController: NavController
    private val viewModel by viewModels<DetailViewModel>()

    private val titles = arrayOf(
        "Shop",
        "Details",
        "Features"
    )

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabLayout

        val adapterViewPager = ViewPagerAdapter(parentFragmentManager, lifecycle)
        viewPager.adapter = adapterViewPager

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = titles[position]
        }.attach()

        val adapter = DetailAdapter()
        val layoutManager = ZoomCenterCardLayoutManager(requireContext(), RecyclerView.HORIZONTAL,true)
        binding.rcView.layoutManager = layoutManager
        binding.rcView.setHasFixedSize(true)
        binding.rcView.addOnScrollListener(CenterScrollListener())
        binding.rcView.adapter = adapter


        // для тестирования ZoomCenterCardLayoutManager
        val images = listOf<String>(
            "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg",
            "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg",
            "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg",
            "https://www.manualspdf.ru/thumbs/products/l/1260237-samsung-galaxy-note-20-ultra.jpg")

        viewModel.getDataDetail()

        viewModel.getDataDetailResult.observe(viewLifecycleOwner){
            //adapter.setListData(it.images)
            adapter.setListData(images)

            binding.ratingView.rating = it.rating.toFloat()

        }

        binding.back.setOnClickListener {
            navController.navigate(R.id.action_detailFragment_to_homeFragment)
        }

        binding.cart.setOnClickListener {
            navController.navigate(R.id.action_detailFragment_to_myCartFragment)
        }

        var count = 0

        binding.btnAdd.setOnClickListener{
            ++count
            binding.notificationsBadgeTextView.text = count.toString()
        }
    }

    companion object {

        fun newInstance() = DetailFragment().apply {
            arguments = Bundle().apply {}
        }
    }
}