package com.example.newsapp.ui.articles

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.newsapp.databinding.FragmentAricleBinding
import com.example.newsapp.ui.sources.SourcesItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AricleFragment : Fragment() {

lateinit var viewBinding: FragmentAricleBinding
 val viewModel: ArticleViewModel by viewModels()
    lateinit var sourceid: SourcesItem
    companion object{
        fun getInstance(sourceid:SourcesItem):AricleFragment{
            val articleFragment =AricleFragment()
            articleFragment.sourceid = sourceid
            return articleFragment
        }}
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

         viewBinding=FragmentAricleBinding.inflate(layoutInflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intiliazeRecyclerView()
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getArticles(sourceid.id.toString())

        }
        loadArticles()
    }

    private fun loadArticles() {
        viewModel.articles.observe(viewLifecycleOwner,object :Observer<List<ArticleItem?>?>{
            override fun onChanged(articles: List<ArticleItem?>?) {
                articleAdapter.setList(articles!!)
            }

        })
    }
   @Inject lateinit var articleAdapter:ArticleAdapter
    private fun intiliazeRecyclerView() {
        viewBinding.newsRecycler.adapter=articleAdapter
    }


    }
