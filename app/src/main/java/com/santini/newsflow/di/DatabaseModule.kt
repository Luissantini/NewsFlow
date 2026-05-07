package com.santini.newsflow.di

import android.app.Application
import androidx.room.Room
import com.santini.newsflow.data.local.NewsDatabase
import com.santini.newsflow.data.local.dao.ArticleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideNewsDatabase(app: Application): NewsDatabase {
        return Room.databaseBuilder(
            app,
            NewsDatabase::class.java,
            "news_db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideArticleDao(db: NewsDatabase): ArticleDao {
        return db.dao
    }
}
