package com.example.kotlindemo.iterator

import com.example.kotlindemo.base.BaseIterator
import com.example.kotlindemo.model.NewsResponse
import com.example.kotlindemo.presenter.NewsPresenter
import io.reactivex.Flowable

interface NewsIterator : BaseIterator<NewsPresenter> {
    fun getListNews() : Flowable<NewsResponse>
}