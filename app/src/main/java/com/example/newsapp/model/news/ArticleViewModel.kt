package com.example.newsapp.model.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.Constans
import com.example.newsapp.api.ApiManager
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ArticleViewModel:ViewModel() {
    var aricles:MutableLiveData<List<ArticleItem?>> =MutableLiveData<List<ArticleItem?>>()
    var erorrMessage:MutableLiveData<String?> = MutableLiveData<String?>()

    fun getArticles(sourceid:String){
        ApiManager.getApi().getArticals(Constans.apiKey,sourceid).enqueue(object :Callback<ArticlesResponse> {
            override fun onResponse(
                call: Call<ArticlesResponse>,
                response: Response<ArticlesResponse>) {

                if(response.isSuccessful)   aricles.value=response.body()?.articles
               return
                    val gson =Gson()
                    val erorrResponse = gson.fromJson(response.errorBody()?.string(),ArticlesResponse::class.java)
                    erorrMessage.value=erorrResponse.message.toString()


            }

            override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
                  erorrMessage.value=t.localizedMessage
            }

        })
    }
}