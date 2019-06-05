package com.example.kotlindemo.view

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.kotlindemo.R
import com.example.kotlindemo.iterator.NewsIteratorImpl
import com.example.kotlindemo.model.News
import com.example.kotlindemo.presenter.NewsPresenter
import com.example.kotlindemo.presenter.NewsPresenterImpl
import io.reactivex.disposables.CompositeDisposable

class NewsActivity : AppCompatActivity(), NewsView {

    private var presenter : NewsPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        start(NewsPresenterImpl(this, NewsIteratorImpl(), CompositeDisposable()))
        presenter?.getListNews()
    }

    override fun onSuccess(news : List<News>) {
        Toast.makeText(this, "Success : " + news.size, Toast.LENGTH_LONG).show()
    }

    override fun onFailed(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun start(presenter: NewsPresenter) {
        this.presenter = presenter
    }

}

