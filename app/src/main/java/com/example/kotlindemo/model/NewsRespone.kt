package com.example.kotlindemo.model

import com.google.gson.annotations.SerializedName

data class NewsResponse constructor (
    @SerializedName("status") var status: String,
    @SerializedName("response")  var response: Response
)

data class Response constructor (
    @SerializedName("news") var news: List<News>
)

data class News constructor(
    @SerializedName("id") var id :Long
)