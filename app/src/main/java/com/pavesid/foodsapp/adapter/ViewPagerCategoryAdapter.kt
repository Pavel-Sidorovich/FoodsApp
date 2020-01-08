package com.pavesid.foodsapp.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.pavesid.foodsapp.model.Categories
import com.pavesid.foodsapp.view.category.CategoryFragment

class ViewPagerCategoryAdapter(fm: FragmentManager, private val categories: List<Categories.Category>):
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getItem(position: Int): Fragment {
        val fragment = CategoryFragment()
        val args = Bundle()

        args.putString("EXTRA_DATA_NAME", categories[position].getStrCategory())
        args.putString("EXTRA_DATA_DESC", categories[position].getStrCategoryDescription())
        args.putString("EXTRA_DATA_IMAGE", categories[position].getStrCategoryThumb())
        fragment.arguments = args
        return fragment
    }

    override fun getCount() = categories.size

    override fun getPageTitle(position: Int): CharSequence? {
        return categories[position].getStrCategory()
    }
}