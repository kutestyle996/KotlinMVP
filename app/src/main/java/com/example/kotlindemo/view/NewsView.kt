package com.example.kotlindemo.view

import com.example.kotlindemo.base.BaseView
import com.example.kotlindemo.model.News
import com.example.kotlindemo.presenter.NewsPresenter

interface NewsView : BaseView<NewsPresenter> {

    fun onSuccess(news : List<News>)

    fun onFailed(message : String)

}