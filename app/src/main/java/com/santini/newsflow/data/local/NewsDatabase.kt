package com.santini.newsflow.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santini.newsflow.data.local.dao.ArticleDao
import com.santini.newsflow.data.local.entities.ArticleEntity

@Database(entities = [ArticleEntity::class], version = 1, exportSchema = false)
abstract class NewsDatabase : RoomDatabase() {
    abstract val dao: ArticleDao
}