package com.santini.newsflow.presentation.new_list

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santini.newsflow.domain.repository.NewsRepository
import com.santini.newsflow.presentation.NewsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val repository: NewsRepository // Hilt inyecta esto automáticamente
) : ViewModel() {

    // El estado que la UI va a observar
    var state by mutableStateOf(NewsState())
        private set

    init {
        getArticles()
    }

    private fun getArticles() {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            try {
                val result = repository.getTopHeadlines("us")
                state = state.copy(
                    articles = result,
                    isLoading = false
                )

            } catch (e: Exception) {
                state = state.copy(
                    error = e.message,
                    isLoading = false
                )
            }
        }
    }
}