package com.example.alkyeassignment.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.alkyeassignment.R
import com.example.alkyeassignment.databinding.FragmentBookmarkBinding
import com.example.alkyeassignment.databinding.FragmentShowsBinding

class ShowsFragment : Fragment() {

    private var _binding: FragmentShowsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_shows, container, false)
        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}