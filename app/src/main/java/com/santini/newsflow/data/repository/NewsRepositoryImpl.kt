package com.santini.newsflow.data.repository

import com.santini.newsflow.data.local.NewsDatabase
import com.santini.newsflow.data.mapper.toDomain
import com.santini.newsflow.data.mapper.toEntity
import com.santini.newsflow.data.remote.NewsApiService
import com.santini.newsflow.domain.model.Article
import com.santini.newsflow.domain.repository.NewsRepository


class NewsRepositoryImpl(
    private val apiService: NewsApiService,
    private val dataBase: NewsDatabase
) : NewsRepository {

    override suspend fun getTopHeadlines(country: String): List<Article> {
        return try {
            val response = apiService.getTopHeadlines(country = country)
            val entities = response.articles.map { it.toEntity() }

            dataBase.dao.clearArticles()
            dataBase.dao.insertArticles(entities)

            entities.map { it.toDomain() }

        } catch (e: Exception) {
           val localCache = dataBase.dao.getArticlesOnce() // Un método que devuelva List, no Flow
            localCache.map { it.toDomain() }
        }
    }
}