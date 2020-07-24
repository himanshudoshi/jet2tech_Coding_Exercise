package com.jet2tech.demo.room

import androidx.room.TypeConverter
import com.google.gson.Gson

class DataTypeConverter {

    @TypeConverter
    fun listOfMediaToJson(value: List<ArticleItem.Medium>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListOfMedia(value: String) = Gson().fromJson(value, Array<ArticleItem.Medium>::class.java).toList()


    @TypeConverter
    fun listOfUserToJson(value: List<ArticleItem.User>?) = Gson().toJson(value)

    @TypeConverter
    fun jsonToListOfUser(value: String) = Gson().fromJson(value, Array<ArticleItem.User>::class.java).toList()
}