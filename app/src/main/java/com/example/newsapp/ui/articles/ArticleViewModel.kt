package com.example.newsapp.ui.articles

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.ApiManager
import com.example.newsapp.repositoriesContract.ArticalsReosatory
import com.example.newsapp.repositories.articles.ArticalsRepositoryImp
import com.example.newsapp.repositories.articles.ArticlesRemotDataSourceImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor( val articalsReo: ArticalsReosatory):ViewModel() {
    var articles:MutableLiveData<List<ArticleItem?>?> =MutableLiveData<List<ArticleItem?>?>()
    var erorrMessage:MutableLiveData<String?> = MutableLiveData<String?>()


    fun getArticles(sourceid:String){
    viewModelScope.launch {
       val data = articalsReo.getArticalsBySourceId(sourceid)
        articles.value =data
    }
    }
}
//
//ApiManager.getApi().getArticals(Constans.apiKey,sourceid).enqueue(object :Callback<ArticlesResponse> {
//    override fun onResponse(
//        call: Call<ArticlesResponse>,
//        response: Response<ArticlesResponse>) {
//
//        if(response.isSuccessful)   aricles.value=response.body()?.articles
//        return
//        val gson =Gson()
//        val erorrResponse = gson.fromJson(response.errorBody()?.string(),ArticlesResponse::class.java)
//        erorrMessage.value=erorrResponse.message.toString()
//
//
//    }
//
//    override fun onFailure(call: Call<ArticlesResponse>, t: Throwable) {
//        erorrMessage.value=t.localizedMessage
//    }
//
//})