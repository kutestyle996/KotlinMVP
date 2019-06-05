package com.example.kotlindemo.base

interface BaseView<P> {
    fun start(presenter : P)
}