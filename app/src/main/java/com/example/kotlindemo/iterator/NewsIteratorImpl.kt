package com.example.kotlindemo.iterator

import com.example.kotlindemo.App
import com.example.kotlindemo.model.NewsResponse
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class NewsIteratorImpl : NewsIterator {

    override fun getListNews(): Flowable<NewsResponse> = App.instance
        .getApiService()
        .getListNews()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

}