package com.example.newsapp.ui.news

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.newsapp.R
import com.example.newsapp.databinding.ArticleitemBinding

class ArticleAdapter(var ArticleList: List<ArticleItem?>?):RecyclerView.Adapter<ArticleAdapter.ArticleViewHoler> (){

    class ArticleViewHoler(val viewBinding:ArticleitemBinding) : RecyclerView.ViewHolder(viewBinding.root){
        fun bind(article:ArticleItem){
            viewBinding.article=article
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHoler {
        val viewBinding= ArticleitemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
           return ArticleViewHoler(viewBinding)
    }

    override fun onBindViewHolder(holder: ArticleViewHoler, position: Int) {
         var item= ArticleList?.get(position)
      holder.bind(item!!)

        Glide.with(holder.viewBinding.root)
            .load(item?.urlToImage)
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.viewBinding.sourceImage);
    }
    fun setList(list:List<ArticleItem?>){
        ArticleList= list
        notifyDataSetChanged()

    }

    override fun getItemCount(): Int {
        return  ArticleList?.size?:0
    }


}