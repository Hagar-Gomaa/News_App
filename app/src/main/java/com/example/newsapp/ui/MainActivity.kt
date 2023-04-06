package com.example.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment

import com.example.newsapp.R
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.ui.category.CategoryFragment
import com.example.newsapp.ui.settings.SettingsFragment
import com.example.newsapp.ui.sources.SourceFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() , CategoryFragment.OnItemClickCallBack {
    override fun onItemClick(categoryid: String) {
        showSourceFragment(categoryid)
    }

    private fun showSourceFragment(categoryid: String) {
        supportFragmentManager.beginTransaction().replace(R.id.layoutContiner,SourceFragment.grtInstance(categoryid)).commit()
    }
    var categoryFragment=CategoryFragment()
    var settingsFragment: SettingsFragment= SettingsFragment()
    lateinit var viewBinding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding =DataBindingUtil.setContentView(this,R.layout.activity_main)
        categoryFragment.onItemClickCallBack = this

        showFragment(categoryFragment)
        val toggle = ActionBarDrawerToggle(
            this, viewBinding.drawer, viewBinding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        viewBinding.drawer.addDrawerListener(toggle)
        toggle.syncState()
        viewBinding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.categories -> {
                    showFragment(categoryFragment);
                }
                R.id.settings -> {
                    showFragment(settingsFragment)
                }
            }
            viewBinding.drawer.closeDrawers()
            return@setNavigationItemSelectedListener true;
        }


    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.layoutContiner,fragment).commit()
    }
}