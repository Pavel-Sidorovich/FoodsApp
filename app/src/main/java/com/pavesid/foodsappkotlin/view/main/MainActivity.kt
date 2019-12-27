package com.pavesid.foodsappkotlin.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.pavesid.foodsappkotlin.R
import com.pavesid.foodsappkotlin.adapter.RecyclerViewMainAdapter
import com.pavesid.foodsappkotlin.adapter.ViewPagerHeaderAdapter
import com.pavesid.foodsappkotlin.model.Categories
import com.pavesid.foodsappkotlin.model.Meals
import com.pavesid.foodsappkotlin.view.category.CategoryActivity
import com.pavesid.foodsappkotlin.view.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_recycler_meal.*
import java.io.Serializable

class MainActivity : AppCompatActivity(), MainView {

    companion object {
        const val EXTRA_CATEGORY = "category"
        const val EXTRA_POSITION = "position"
        const val EXTRA_DETAIL = "detail"
    }

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        presenter = MainPresenter(this)
        presenter.getCategories()
        presenter.getMeals()
        search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                presenter.getSearchMeal(s.toString())
                presenter.getMeals()
            }

        })
    }

    override fun showLoading() {
        shimmerMeal.visibility = View.VISIBLE
        shimmerCategory.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        shimmerMeal.visibility = View.GONE
        shimmerCategory.visibility = View.GONE
    }

    override fun setMeal(meal: List<Meals.Meal>?) {

        val viewPagerHeaderAdapter = ViewPagerHeaderAdapter(meal ?: listOf(), this)
        viewPagerHeader.adapter = viewPagerHeaderAdapter
        viewPagerHeader.setPadding(20, 0, 160, 0)
        viewPagerHeaderAdapter.notifyDataSetChanged()

        viewPagerHeaderAdapter.setOnItemClickListener(object :
            ViewPagerHeaderAdapter.ClickListener {
            override fun onClick(view: View, position: Int) {

                val intent = Intent(this@MainActivity, DetailActivity::class.java)
                // add extra data (put to intent)
                intent.putExtra(EXTRA_DETAIL, mealName.text.toString())
                startActivity(intent)
            }
        })
    }

    override fun setCategory(category: List<Categories.Category>?) {

        val recyclerViewMainAdapter =
            RecyclerViewMainAdapter(category ?: listOf(), this)
        recyclerCategory.adapter = recyclerViewMainAdapter
        val layoutManager = GridLayoutManager(this, 3, GridLayoutManager.VERTICAL, false)
        recyclerCategory.layoutManager = layoutManager
        recyclerCategory.isNestedScrollingEnabled = true
        recyclerViewMainAdapter.notifyDataSetChanged()

        recyclerViewMainAdapter.setOnItemClickListener(object :
            RecyclerViewMainAdapter.ClickListener {
            override fun onClick(view: View?, position: Int) {
                val intent = Intent(this@MainActivity, CategoryActivity::class.java)
                // add extra data (put to intent)
                intent.putExtra(EXTRA_CATEGORY, category as Serializable)
                intent.putExtra(EXTRA_POSITION, position)
                startActivity(intent)
            }
        })
    }

    override fun onErrorLoading(message: String?) {

    }
}
