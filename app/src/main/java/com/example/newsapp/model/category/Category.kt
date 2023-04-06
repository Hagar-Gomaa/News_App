package com.example.newsapp.model.category

import com.example.newsapp.R

data class Category(var name:String,var id:String,var imageid:Int,var backgroundcolor:Int){

    companion object{
        fun getCategories():List<Category>{
              return listOf(Category("sports","sports", R.drawable.sports,R.color.red),
                  Category("general","general", R.drawable.politics,R.color.blue),
                  Category("health","health", R.drawable.health,R.color.pink),
                  Category("business","business", R.drawable.bussines,R.color.orange),
                  Category("technology","technology", R.drawable.environment,R.color.lightBlue),
                  Category("science","science", R.drawable.science,R.color.yellow))
        }
    }
}


