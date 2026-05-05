package com.santini.newsflow.data.mapper

import com.santini.newsflow.data.remote.dto.ArticleDto
import com.santini.newsflow.domain.model.Article

fun ArticleDto.toDomain(): Article {
    return Article(
        title = this.title ?: "Sin título", // Si viene nulo, le ponemos un valor por defecto
        author = this.author ?: "Autor desconocido",
        imageUrl = this.urlToImage ?: "https://link-a-imagen-por-defecto.png"
    )
}