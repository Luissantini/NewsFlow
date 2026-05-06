package com.santini.newsflow.presentation.new_list

import com.santini.newsflow.domain.model.Article

data class NewsState(val articles: List<Article> = emptyList(),
                     val isLoading: Boolean = false,
                     val error: String? = null)