package com.example.newsapp.ui.news

import com.google.gson.annotations.SerializedName

data class ArticlesResponse(

	@field:SerializedName("totalResults")
	val totalResults: Int? = null,

	@field:SerializedName("articles")
	val articles: List<ArticleItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null,

	@field:SerializedName("code")
     val code: String? = null,

    @field:SerializedName("message")
    val message: String? = null
)