package com.pavesid.foodsapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pavesid.foodsapp.R
import com.pavesid.foodsapp.model.Categories
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_recycler_category.view.*

class RecyclerViewMainAdapter(private val categories: List<Categories.Category>, private val context: Context) :
    RecyclerView.Adapter<RecyclerViewMainAdapter.RecyclerViewMainViewHolder>() {

    lateinit var clickListener: ClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerViewMainViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.item_recycler_category,
            parent, false
        )
        return RecyclerViewMainViewHolder(view)
    }

    override fun getItemCount() = categories.size

    override fun onBindViewHolder(holder: RecyclerViewMainViewHolder, position: Int) {
        val strCategoryThum = categories[position].getStrCategoryThumb()
        Picasso.get().load(strCategoryThum).placeholder(R.drawable.ic_circle)
            .into(holder.itemView.categoryThumb)

        val strCategoryName = categories[position].getStrCategory()
        holder.itemView.categoryName.text = strCategoryName
    }

    inner class RecyclerViewMainViewHolder(convertView: View) :
        RecyclerView.ViewHolder(convertView), View.OnClickListener {
        init {
            convertView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener.onClick(v, adapterPosition)
        }
    }

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onClick(view: View?, position: Int)
    }
}