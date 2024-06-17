package com.example.alkyeassignment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.alkyeassignment.R
import com.example.alkyeassignment.adapter.HorizontalAdapter
import com.example.alkyeassignment.adapter.SocialAdapter
import com.example.alkyeassignment.adapter.VerticalAdapter
import com.example.alkyeassignment.databinding.FragmentHomeBinding
import com.example.alkyeassignment.loadJsonFromAssets
import com.example.alkyeassignment.model.DetailData
import com.example.alkyeassignment.parseJson

class HomeFragment : Fragment() {

    //Initialize binding object

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setupRecyclerView(binding.rvHorizontal, "myData.json") { dataList -> HorizontalAdapter(dataList) }
        setupRecyclerView(binding.rvVerticalSocial, "myData.json") { dataList -> SocialAdapter(dataList) }
        setupRecyclerView(binding.rvVertical, "myData.json") { dataList -> VerticalAdapter(dataList, false) }

        // To show all data by click on viewAll Button
        binding.btnViewAll.setOnClickListener {
            setupRecyclerView(binding.rvVertical, "myData.json") { dataList -> VerticalAdapter(dataList, true) }
        }
        return binding.root
    }

    //Method to read data from json file and add data in recyclerView

    private fun setupRecyclerView(recyclerView: RecyclerView, jsonFileName: String, adapterFactory: (List<DetailData>) -> RecyclerView.Adapter<*>) {
        val jsonFileString = loadJsonFromAssets(requireContext(), jsonFileName)
        if (jsonFileString != null) {
            val dataList = parseJson(jsonFileString)
            recyclerView.adapter = adapterFactory(dataList)
        }
    }

    // Destroy binding object, when fragment Destroy

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}