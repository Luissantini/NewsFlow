package com.santini.newsflow.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "articles")

data class ArticleEntity(
    @PrimaryKey val url: String,
    val title: String,
    val author: String?,
    val imageUrl: String?,
    val description: String?,
    val publishedAt: String
)