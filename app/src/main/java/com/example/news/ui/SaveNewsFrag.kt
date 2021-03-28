package com.example.news.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.news.R
import com.example.news.databinding.FragmentBreakingNewsBinding
import com.example.news.databinding.FragmentSaveNewsBinding


class SaveNewsFrag : Fragment() {
    private var _binding: FragmentSaveNewsBinding?=null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentSaveNewsBinding.inflate(inflater,container,false).run {
            _binding = this
            root
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}