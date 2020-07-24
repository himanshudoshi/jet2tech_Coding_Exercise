package com.jet2tech.demo.room

import android.app.Application
import android.os.AsyncTask


class ArticleItemRepository(application: Application) {

    private var articleItemDao: ArticleItemDao? = null
    private var allArticleItems: MutableList<ArticleItem>? = null

    init {
        val database =
            ArticleDatabase.getInstance(application)
        articleItemDao = database?.itemDao()
        allArticleItems = articleItemDao?.getAllArticles()
    }

    fun insert(articleItems: MutableList<ArticleItem>) {
        for (value in articleItems){
            InsertNoteAsyncTask(articleItemDao).execute(value)
        }
    }

    fun update(articleItem: ArticleItem) {
        UpdateNoteAsyncTask(articleItemDao).execute(articleItem)
    }

    fun delete(articleItem: ArticleItem) {
        DeleteNoteAsyncTask(articleItemDao).execute(articleItem)
    }

    fun deleteAllNotes() {
        DeleteAllNotesAsyncTask(articleItemDao).execute()
    }

    fun getAllItems(): MutableList<ArticleItem>? {
        return allArticleItems
    }

    class InsertNoteAsyncTask(private val articleItemDao: ArticleItemDao?):AsyncTask<ArticleItem, Void, Void>() {
        override fun doInBackground(vararg params: ArticleItem?): Void? {
            articleItemDao?.insert(params[0]!!)
            return null
        }
    }

    class UpdateNoteAsyncTask(private val articleItemDao: ArticleItemDao?):AsyncTask<ArticleItem, Void, Void>() {
        override fun doInBackground(vararg params: ArticleItem?): Void? {
            articleItemDao?.update(params[0]!!)
            return null
        }
    }

    class DeleteNoteAsyncTask(private val articleItemDao: ArticleItemDao?):AsyncTask<ArticleItem, Void, Void>() {
        override fun doInBackground(vararg params: ArticleItem?): Void? {
            articleItemDao?.delete(params[0]!!)
            return null
        }
    }

    class DeleteAllNotesAsyncTask(private val articleItemDao: ArticleItemDao?):AsyncTask<ArticleItem, Void, Void>() {
        override fun doInBackground(vararg params: ArticleItem?): Void? {
            articleItemDao?.deleteAllArticles()
            return null
        }
    }
}


