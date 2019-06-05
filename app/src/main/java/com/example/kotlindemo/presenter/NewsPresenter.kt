package com.example.kotlindemo.presenter

import com.example.kotlindemo.base.BasePresenter
import com.example.kotlindemo.iterator.NewsIterator
import com.example.kotlindemo.view.NewsView

interface NewsPresenter : BasePresenter<NewsView, NewsIterator> {
    fun getListNews()
}