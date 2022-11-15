package com.etoolkit.myapp.presention.cart

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.etoolkit.myapp.R
import com.etoolkit.myapp.databinding.FragmentMyCartBinding

class MyCartFragment : Fragment() {

    private lateinit var binding: FragmentMyCartBinding
    private val viewModel by viewModels<MyCardViewModel>()
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMyCartBinding.inflate(layoutInflater)
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BasketAdapter()
        binding.myCardRecyclerView.adapter = adapter

        viewModel.getCartData()

        viewModel.getCartDataResult.observe(viewLifecycleOwner){

            invisibleShimmer()

            Log.d("MyLog","getCartDataResult = $it")
            adapter.setListData(it.basket)

            binding.total.text = "$${it.total}us"
            binding.delivery.text = it.delivery
        }

        binding.back.setOnClickListener {
            navController.navigate(R.id.action_myCartFragment_to_detailFragment)
        }
    }


    // startShimmerAnimation()
    private fun visibilityShimmer(){
        binding.shimmerContainer.startShimmerAnimation()
        binding.shimmerContainer.visibility = View.VISIBLE
        binding.myCardRecyclerView.visibility = View.GONE
    }

    // stopShimmerAnimation
    private fun invisibleShimmer(){
        binding.shimmerContainer.stopShimmerAnimation()
        binding.shimmerContainer.visibility = View.GONE
        binding.myCardRecyclerView.visibility = View.VISIBLE
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

        fun newInstance() = MyCartFragment().apply {
            arguments = Bundle().apply {}
        }
    }

}