package com.example.news.data.entities


import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.news.utils.Constant.ARTICLE_TABLE_NAME
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = ARTICLE_TABLE_NAME)
data class Article(
    @Json(name = "author")
    val author: String?,
    @Json(name = "content")
    val content: String?,
    @Json(name = "description")
    val description: String?,
    @Json(name = "publishedAt")
    val publishedAt: String?,
    @Json(name = "source")
    val source: Source?,
    @Json(name = "title")
    val title: String?,
    @Json(name = "url")
    val url: String?,
    @Json(name = "urlToImage")
    val urlToImage: String?
):Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id : Long? = 0
}