package com.santini.newsflow.data.mapper

import com.santini.newsflow.data.local.entities.ArticleEntity
import com.santini.newsflow.data.remote.dto.ArticleDto
import com.santini.newsflow.domain.model.Article


fun ArticleDto.toEntity(): ArticleEntity {
    return ArticleEntity(
        url = this.url ?: "",
        title = this.title ?: "Sin título",
        author = this.author ?: "Autor desconocido",
        imageUrl = this.urlToImage ?: "https://link-a-imagen-por-defecto.png",
        description = this.description ?: "",
        publishedAt = this.publishedAt ?: ""
    )
}


fun ArticleEntity.toDomain(): Article {
    return Article(
        title = this.title,
        author = this.author,
        imageUrl = this.imageUrl ?: ""
    )
}