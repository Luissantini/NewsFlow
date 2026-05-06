package com.santini.newsflow.data.repository

import com.santini.newsflow.data.mapper.toDomain
import com.santini.newsflow.data.remote.dto.NewsApiService
import com.santini.newsflow.domain.model.Article
import com.santini.newsflow.domain.repository.NewsRepository


class NewsRepositoryImpl(
    private val apiService: NewsApiService
) : NewsRepository {
    override suspend fun getTopHeadlines(country: String): List<Article> {
        val response = apiService.getTopHeadlines(country = country)
        // Convertimos la lista de DTOs en una lista de Artículos de dominio
        return response.articles.map { it.toDomain() }
    }
}