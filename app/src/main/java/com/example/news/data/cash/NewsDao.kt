package com.example.news.data.cash

import androidx.room.*
import com.example.news.data.entities.Article
import com.example.news.utils.Constant
import kotlinx.coroutines.flow.Flow

@Dao
interface NewsDao {     //دیتابیس افلاین
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert (article:Article):Flow<Long>

    @Query(" SELECT * FROM " + Constant.ARTICLE_TABLE_NAME)
    fun getAllArticle():Flow<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}