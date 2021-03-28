package com.example.news.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.android.tools.build.jetifier.core.utils.Log
import com.example.news.R
import com.example.news.databinding.FragmentArticleBinding
import com.example.news.databinding.FragmentBreakingNewsBinding
import com.example.news.utils.Resource
import com.example.news.utils.Status
import com.example.news.viewmodel.BreakingNewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BreakingNewsFrag : Fragment() {
    private var _binding: FragmentBreakingNewsBinding?=null
    private val binding get() = _binding

    private val viewModel by viewModels<BreakingNewsViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentBreakingNewsBinding.inflate(inflater,container,false).run {
            _binding = this
            root
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            viewModel.apply {
                lifecycleScope.launch {
                    getBreakingNewsStateFlow.collect {
                        when (it.status){
                            Status.SUCCESS->{

                            }
                            Status.ERROR->{

                            }
                            Status.LOADING->{

                            }
                        }
                    }
                }
            }

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}