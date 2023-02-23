package com.example.newsapp.ui.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.FragmentAricleBinding
import com.example.newsapp.ui.sources.SourcesItem


class AricleFragment : Fragment() {

lateinit var viewBinding: FragmentAricleBinding
lateinit var viewModel: ArticleViewModel
    lateinit var sourceid: SourcesItem
    companion object{
        fun getInstance(sourceid:SourcesItem):AricleFragment{
            val articleFragment =AricleFragment()
            articleFragment.sourceid = sourceid
            return articleFragment
        }}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(ArticleViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

         viewBinding=FragmentAricleBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiliazeRecyclerView()
        viewModel.getArticles(sourceid.id.toString())
        loadArticles()
    }

    private fun loadArticles() {
        viewModel.aricles.observe(viewLifecycleOwner,object :Observer<List<ArticleItem?>>{
            override fun onChanged(articles: List<ArticleItem?>?) {
                articleAdapter.setList(articles!!)
            }

        })
    }
    val articleAdapter=ArticleAdapter(null)
    private fun intiliazeRecyclerView() {
        viewBinding.newsRecycler.adapter=articleAdapter
    }


    }
