package com.example.newsapp.model.sources

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapp.Constans
import com.example.newsapp.api.ApiManager
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SourceViewModel :ViewModel(){
var ListLiveData :MutableLiveData<List<SourcesItem?>> =MutableLiveData<List<SourcesItem?>>()
   var erorrmessage :MutableLiveData<String?> = MutableLiveData<String?>()

    fun getSources(categoryid:String){
     ApiManager.getApi().getSources(Constans.apiKey,categoryid).enqueue(object :Callback<SourcesResponse>{
         override fun onResponse(
             call: Call<SourcesResponse>,
             response: Response<SourcesResponse>) = if (response.isSuccessful){
             ListLiveData.value= response.body()?.sources
         }else{
                 val gson:Gson=Gson()
                 val errorResponse= gson.fromJson(response.errorBody()?.string(),SourcesResponse::class.java)
                       erorrmessage.value=errorResponse.message

             }

         override fun onFailure(call: Call<SourcesResponse>, t: Throwable) {
                     erorrmessage.value=t.localizedMessage
         }

     })
    }
}