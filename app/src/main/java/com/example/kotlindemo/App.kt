package com.example.kotlindemo

import android.app.Application
import com.example.kotlindemo.model.ApiService
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class App() : Application() {

    private val READ_TIMEOUT = 5000
    private val WRITE_TIMEOUT = 5000
    private val CONNECT_TIMEOUT = 5000
    private val BASE_URL = "http://172.16.14.142/18175d1_mobile_100_fresher/public/api/v0/"

    private object Holder {
        val INSTANCE = App()
    }

    companion object {
        val instance: App by lazy {
            Holder.INSTANCE
        }
    }

    public fun getApiService(): ApiService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(getOkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(READ_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .writeTimeout(WRITE_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .connectTimeout(CONNECT_TIMEOUT.toLong(), TimeUnit.MILLISECONDS)
            .build()
    }
}