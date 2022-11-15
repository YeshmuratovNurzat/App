package com.etoolkit.myapp.presention.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.etoolkit.myapp.R

class FeaturesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_features, container, false)
    }

    companion object {

        fun newInstance() = FeaturesFragment().apply {
            arguments = Bundle().apply {
            }
        }
    }

}