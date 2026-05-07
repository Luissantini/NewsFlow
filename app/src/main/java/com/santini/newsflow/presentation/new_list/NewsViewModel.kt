package com.santini.newsflow.presentation.new_list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santini.newsflow.domain.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository
) : ViewModel() {
    var state by mutableStateOf(NewsState())
        private set

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch {
            state = state.copy(isLoading = true, error = null)
            val result = repository.getTopHeadlines("us")
            if (result.isNotEmpty()) {
                state = state.copy(
                    articles = result,
                    isLoading = false
                )
            } else {
                state = state.copy(
                    isLoading = false,
                    error = "No hay noticias disponibles, revisa tu conexión."
                )
            }
        }
    }
}