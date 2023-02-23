package com.example.newsapp.ui.category

import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter

    @BindingAdapter("cardColor")
    fun cardColor(card:CardView,color:Int){
        card.setCardBackgroundColor(ContextCompat.getColor(card.context,color))
    }
    @BindingAdapter("image")
    fun imageView(image:ImageView,imageid:Int){
        image.setImageResource(imageid)
    }
