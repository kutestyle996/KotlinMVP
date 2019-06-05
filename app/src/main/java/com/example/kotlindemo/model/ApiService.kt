package com.example.kotlindemo.model

import com.example.kotlindemo.model.NewsResponse
import io.reactivex.Flowable
import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {

    @GET("listNews")
    fun getListNews(): Flowable<NewsResponse>

}