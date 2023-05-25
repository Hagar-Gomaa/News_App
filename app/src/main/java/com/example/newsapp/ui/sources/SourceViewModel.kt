package com.example.newsapp.ui.sources

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapp.api.ApiManager
import com.example.newsapp.repositoriesContract.SourceReosatory
import com.example.newsapp.repositories.sources.SourcesRemoteDataSourceImp
import com.example.newsapp.repositories.sources.SourcesRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class SourceViewModel @Inject constructor(val  sourcesRepo:SourceReosatory) :ViewModel(){
var ListLiveData :MutableLiveData<List<SourcesItem?>?> =MutableLiveData<List<SourcesItem?>?>()
   var erorrmessage :MutableLiveData<String?> = MutableLiveData<String?>()


   fun getSources(categoryid:String) {
       val mflow = flow<List<SourcesItem?>?> {
           emit(sourcesRepo.getSourceByCategoryId(categoryid))
       }
 viewModelScope.launch {
     mflow.collect{
            ListLiveData.value=it
     }
 }

   }
}

//        viewModelScope.launch{
//            val data = sourcesRepo.getSourceByCategoryId(categoryid)
//            ListLiveData.value=data       }
//    }

/**
 *  ApiManager.getApi().getSources(Constans.apiKey,categoryid).enqueue(object :Callback<SourcesResponse>{
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
 */