package com.example.newsapp.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {
    lateinit var viewBinding:FragmentCategoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
         viewBinding=FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
      val adapter= CategoryAdapter(Category.getCategories())
        viewBinding.categoriesRecycler.adapter=adapter

           adapter.onItemClickListener= object :CategoryAdapter.OnItemClickListener{
               override fun onItemClick(item: Category, position: Int) {
                   super.onItemClick(item, position)
                   onItemClickCallBack?.onItemClick(item.id)
               }
           }
        }
     var onItemClickCallBack:OnItemClickCallBack?=null
    interface OnItemClickCallBack{
    fun onItemClick(categoryid: String)}
}

