package com.example.news.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.android.tools.build.jetifier.core.utils.Log
import com.example.news.R
import com.example.news.databinding.FragmentArticleBinding
import com.example.news.databinding.FragmentBreakingNewsBinding
import com.example.news.ui.adapter.BreakingNewsAdapter
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

    //private lateinit var newsAdapter: BreakingNewsAdapter

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
                            Status.SUCCESS -> {
                                rvBreakingNews.adapter = BreakingNewsAdapter { article ->
                                        findNavController().navigate(BreakingNewsFragDirections.actionBreakingNewsFragToArticleFrag(article))

                                }.apply {
                                    it.data?.let { response ->
                                        differ.submitList(response.articles)
                                    }
                                }

                                pageinationProgressBar.visibility = View.GONE
                                rvBreakingNews.visibility = View.VISIBLE
                            }
                            Status.ERROR->{
                                Toast.makeText(requireContext(),"you have an error",Toast.LENGTH_SHORT).show()
                                pageinationProgressBar.visibility = View.VISIBLE
                                rvBreakingNews.visibility = View.GONE
                            }
                            Status.LOADING->{
                                pageinationProgressBar.visibility = View.VISIBLE
                                rvBreakingNews.visibility = View.GONE
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