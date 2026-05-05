package com.santini.newsflow.data.remote.dto

data class NewsResponse(
    val articles: List<ArticleDto>,
    val status: String,
    val totalResults: Int
)

data class ArticleDto(
    val author: String?,
    val content: String?,
    val description: String?,
    val publishedAt: String,
    val title: String,
    val url: String,
    val urlToImage: String?
)