package com.santini.newsflow.di

import com.santini.newsflow.data.remote.dto.NewsApiService
import com.santini.newsflow.data.repository.NewsRepositoryImpl
import com.santini.newsflow.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideNewsApiService(): NewsApiService {
        return Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(apiService: NewsApiService): NewsRepository {
        return NewsRepositoryImpl(apiService)
    }
}