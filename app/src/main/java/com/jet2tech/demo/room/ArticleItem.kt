package com.jet2tech.demo.room

import androidx.room.*

@Entity(tableName = "article_table")
class ArticleItem {
    @PrimaryKey(autoGenerate = false)
    public val id: String = ""
    public val createdAt: String = ""
    public val content: String = ""
    public val comments: Int = 0
    public val likes: Int = 0
    
    @ColumnInfo(name = "list_media")
    @TypeConverters(DataTypeConverter::class)
    public val media: List<Medium> = ArrayList()

    @ColumnInfo(name = "list_user")
    @TypeConverters(DataTypeConverter::class)
    public val user: List<User> = ArrayList()

    inner class Medium {
        public val id: String = ""
        public val blogId: String = ""
        public val createdAt: String = ""
        public val image: String = ""
        public val title: String = ""
        public val url: String = ""
    }

    inner class User {
        public val id: String = ""
        public val blogId: String = ""
        public val createdAt: String = ""
        public val name: String = ""
        public val avatar: String = ""
        public val lastname: String = ""
        public val city: String = ""
        public val designation: String = ""
        public val about: String = ""
    }
}