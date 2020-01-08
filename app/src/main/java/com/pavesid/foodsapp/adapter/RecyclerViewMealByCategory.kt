package com.pavesid.foodsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavesid.foodsapp.R
import com.pavesid.foodsapp.model.Meals
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler_meal.view.*

class RecyclerViewMealByCategory(private val meals: List<Meals.Meal>, private val context: Context?) :
    RecyclerView.Adapter<RecyclerViewMealByCategory.RecyclerViewHolder>() {

    private lateinit var clickListener: ClickListener

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_recycler_meal,
            parent, false
        )
        return RecyclerViewHolder(view)    }

    override fun getItemCount() = meals.size

    override fun onBindViewHolder(holder: RecyclerViewHolder, position: Int) {
        val strMealThumb = meals[position].getStrMealThumb()
        Picasso.get().load(strMealThumb).placeholder(R.drawable.shadow_bottom_to_top)
            .into(holder.itemView.mealThumb)

        val strMealName = meals[position].getStrMeal()
        holder.itemView.mealName.text = strMealName
        holder.itemView.setOnClickListener { v -> clickListener.onClick(v, position) }
    }

    inner class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface ClickListener {
        fun onClick(view: View, position: Int)
    }
}