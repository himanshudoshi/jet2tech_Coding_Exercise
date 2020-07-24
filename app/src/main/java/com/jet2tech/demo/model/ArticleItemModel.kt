package com.jet2tech.demo.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class ArticleItemModel {
    @SerializedName("id")
    public val id: String = ""

    @SerializedName("createdAt")
    public val createdAt: String = ""

    @SerializedName("content")
    public val content: String = ""

    @SerializedName("comments")
    public val comments: Int = 0

    @SerializedName("likes")
    public val likes: Int = 0

    @SerializedName("media")
    public val media: List<Medium> = ArrayList()

    @SerializedName("user")
    public val user: List<User> = ArrayList()

    inner class Medium : Serializable {
        @SerializedName("id")
        public val id: String = ""

        @SerializedName("blogId")
        public val blogId: String = ""

        @SerializedName("createdAt")
        public val createdAt: String = ""

        @SerializedName("image")
        public val image: String = ""

        @SerializedName("title")
        public val title: String = ""

        @SerializedName("url")
        public val url: String = ""
    }

    inner class User : Serializable {
        @SerializedName("id")
        public val id: String = ""

        @SerializedName("blogId")
        public val blogId: String = ""

        @SerializedName("createdAt")
        public val createdAt: String = ""

        @SerializedName("name")
        public val name: String = ""

        @SerializedName("avatar")
        public val avatar: String = ""

        @SerializedName("lastname")
        public val lastname: String = ""

        @SerializedName("city")
        public val city: String = ""

        @SerializedName("designation")
        public val designation: String = ""

        @SerializedName("about")
        public val about: String = ""
    }
}