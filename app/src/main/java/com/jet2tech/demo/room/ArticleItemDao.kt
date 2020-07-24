package com.jet2tech.demo.room

import androidx.room.*


@Dao
interface ArticleItemDao {

    @Insert
    fun insert(note: ArticleItem)

    @Update
    fun update(note: ArticleItem)

    @Delete
    fun delete(note: ArticleItem)

    @Query("DELETE FROM article_table")
    fun deleteAllArticles()

    @Query("SELECT * FROM article_table")
    fun getAllArticles(): MutableList<ArticleItem>

}