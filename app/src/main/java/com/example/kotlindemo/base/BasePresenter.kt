package com.example.kotlindemo.base

interface BasePresenter<V, I> {
    fun takeView(view: V)
    fun dropView()
    fun takeIterator(iterator: I)
}