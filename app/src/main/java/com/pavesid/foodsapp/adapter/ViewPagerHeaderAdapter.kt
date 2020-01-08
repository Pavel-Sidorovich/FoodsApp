package com.pavesid.foodsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.PagerAdapter
import com.pavesid.foodsapp.R
import com.pavesid.foodsapp.model.Meals
import com.squareup.picasso.Picasso

class ViewPagerHeaderAdapter(private val meals: List<Meals.Meal>, private val context: Context) : PagerAdapter() {

    private lateinit var clickListener: ClickListener

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun isViewFromObject(view: View, o: Any) = view == o

    override fun getCount() = meals.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_view_pager_header,
            container,
            false
        )

        val mealThumb: ImageView = view.findViewById(R.id.mealThumb)
        val mealName: TextView = view.findViewById(R.id.mealName)

        val strMealThumb = meals[position].getStrMealThumb()
        Picasso.get().load(strMealThumb).into(mealThumb)

        mealName.text = meals[position].getStrMeal()

        view.setOnClickListener { v -> clickListener.onClick(v, position) }

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, o: Any) {
        container.removeView(o as View)
    }

    interface ClickListener {
        fun onClick(view: View, position: Int)
    }
}