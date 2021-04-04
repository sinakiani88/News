package com.example.news.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.build.api.transform.Status
import com.android.ide.common.rendering.api.Result
import com.example.news.data.entities.NewsResponse
import com.example.news.repository.BreakingNewsRepository
import com.example.news.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel     //دریافت از رپوزیتوری
class BreakingNewsViewModel @Inject constructor(private val breakingNewsRepository: BreakingNewsRepository)
    :ViewModel() {

    private val breakingNewsStateFlow = MutableStateFlow <Resource< NewsResponse? , String? >>(Resource.loading(null))

    init {
        fetchBreakingNews("us",1)
    }

   private fun fetchBreakingNews(countryCode:String,pageNumber:Int){
        viewModelScope.launch {
            breakingNewsRepository.getBreakingNews(
                countryCode = countryCode,
                pageNumber = pageNumber
            ).collect {
                when (it.status) {
                    com.example.news.utils.Status.SUCCESS -> {
                        breakingNewsStateFlow.value = Resource.success(it.data)

                    }
                    com.example.news.utils.Status.ERROR -> {
                        breakingNewsStateFlow.value = Resource.error(message = it.message)

                    }
                    else -> {
                        breakingNewsStateFlow.value = Resource.loading(null)
                    }
                }
            }
        }
    }
    val getBreakingNewsStateFlow: MutableStateFlow<Resource<NewsResponse?, String?>> = breakingNewsStateFlow
}