package com.jet2tech.demo.repository

import com.jet2tech.demo.model.ArticleItemModel
import io.reactivex.Observable
import retrofit2.http.*

interface APIService {
    /**
     * @Base APIService interface :  This interface contain the all the mehtods
    of apis (Communicate to  servers with predefined parameters ).
     **/
    @GET("blogs")
    fun getListDate(
        @Query(value = "page") page: Int,
        @Query(value = "limit") limit: Int
    ): Observable<MutableList<ArticleItemModel>>
}