package com.example.newsapp.model.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import com.example.newsapp.databinding.CategoryItemBinding

class CategoryAdapter(var categoriesList: List<Category>):RecyclerView.Adapter<CategoryAdapter.CategoryViewHoler> (){

    class CategoryViewHoler( val viewBinding:CategoryItemBinding) : RecyclerView.ViewHolder(viewBinding.root){

        fun bind(category: Category){
             viewBinding.category=category
         }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHoler {
        val viewBinding= CategoryItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
           return CategoryViewHoler(viewBinding)
    }

    override fun onBindViewHolder(holder: CategoryViewHoler, position: Int) {
       holder.bind(categoriesList[position])
        onItemClickListener?.let { clicked -> holder.viewBinding.categoryCard.setOnClickListener {
            clicked.onItemClick(categoriesList[position],position)
        }}
    }
    fun setList(list:List<Category>){
        categoriesList= list
        notifyDataSetChanged()

    }var onItemClickListener:OnItemClickListener?=null
    interface OnItemClickListener{
        fun onItemClick(item:Category,position: Int){}}

    override fun getItemCount(): Int {
        return  categoriesList.size
    }
}




