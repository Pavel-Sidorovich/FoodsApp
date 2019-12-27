package com.pavesid.foodsappkotlin.view.category

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.pavesid.foodsappkotlin.R
import com.pavesid.foodsappkotlin.adapter.ViewPagerCategoryAdapter
import com.pavesid.foodsappkotlin.model.Categories
import com.pavesid.foodsappkotlin.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_category.*

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        initActionBar()
        initIntent()
    }

    private fun initIntent() {
        val categories: List<Categories.Category> =
            intent.getSerializableExtra(MainActivity.EXTRA_CATEGORY) as List<Categories.Category>
        val position = intent.getIntExtra(MainActivity.EXTRA_POSITION, 0)

        val viewPagerCategoryAdapter = ViewPagerCategoryAdapter(supportFragmentManager, categories)

        viewPager.adapter = viewPagerCategoryAdapter
        tabLayout.setupWithViewPager(viewPager)
        viewPager.setCurrentItem(position, true)
        viewPagerCategoryAdapter.notifyDataSetChanged()
    }

    private fun initActionBar() {
//        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            onBackPressed()
        }
        return true
    }
}
