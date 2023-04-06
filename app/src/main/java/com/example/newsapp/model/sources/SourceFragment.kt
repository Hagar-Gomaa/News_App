package com.example.newsapp.model.sources

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentSourceBinding
import com.example.newsapp.model.news.AricleFragment
import com.google.android.material.tabs.TabLayout

class SourceFragment : Fragment() {
lateinit var viewBinding: FragmentSourceBinding
lateinit var viewModel: SourceViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
          viewBinding =FragmentSourceBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(SourceViewModel::class.java)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeViewmodel()
        onTabSelected()

    }

    private fun onTabSelected() {
        viewBinding.tablayout.getTabAt(0)?.select()
        viewBinding.tablayout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                showArticlesFragment(tab?.tag as SourcesItem)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {


                showArticlesFragment(tab?.tag as SourcesItem)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }
    private fun showArticlesFragment(sourceid:SourcesItem) {
        childFragmentManager.beginTransaction().replace(R.id.articlesContiner,AricleFragment.getInstance(sourceid)).commit()
    }

    private fun subscribeViewmodel() {
        viewModel.getSources(categoryid)
        viewModel.run { ListLiveData.observe(viewLifecycleOwner,object :Observer<List<SourcesItem?>>{
            override fun onChanged(sources: List<SourcesItem?>?) {
                bindSourcesToTablayout(sources)            }

        })
        }
    }

    private fun bindSourcesToTablayout(sourcelist: List<SourcesItem?>?) {
       sourcelist?.forEach { sourcesItem ->
           val tab = viewBinding.tablayout.newTab()
           tab.text=sourcesItem?.name
           tab.tag=sourcesItem
           viewBinding.tablayout.addTab(tab)
       }
    }lateinit var categoryid:String
companion object{
    fun grtInstance(categoryid:String):SourceFragment{
        var sourceFragment=SourceFragment()
        sourceFragment.categoryid=categoryid
        return sourceFragment
    }
}

}
