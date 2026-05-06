package com.santini.newsflow.domain.repository

import com.santini.newsflow.domain.model.Article

interface NewsRepository {
    suspend fun getTopHeadlines(country: String): List<Article>
}