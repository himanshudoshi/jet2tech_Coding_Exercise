package com.jet2tech.demo.room

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase


abstract class ArticleDatabase : RoomDatabase() {



    public abstract fun itemDao(): ArticleItemDao

    companion object {

        var instance: ArticleDatabase? = null

        @Synchronized
        fun getInstance(context: Context): ArticleDatabase? {
            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    ArticleDatabase::class.java, "article_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }
}