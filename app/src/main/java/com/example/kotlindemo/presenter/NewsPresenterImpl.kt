package com.example.kotlindemo.presenter

import com.example.kotlindemo.iterator.NewsIterator
import com.example.kotlindemo.view.NewsView
import io.reactivex.disposables.CompositeDisposable

class NewsPresenterImpl(var view: NewsView, var iterator: NewsIterator, var compositeDisposable: CompositeDisposable) : NewsPresenter {

    override fun getListNews() {
        val disposable = iterator.getListNews().subscribe(
            { newsResponse ->
                view.onSuccess(newsResponse.response.news)
            },
            { throwable ->
                throwable.message?.let { view.onFailed(it) }
            })
        compositeDisposable.add(disposable)
    }

    override fun takeView(view: NewsView) {
        this.view = view
    }

    override fun dropView() {
        compositeDisposable.clear()
    }

    override fun takeIterator(iterator: NewsIterator) {
        this.iterator = iterator
    }
}