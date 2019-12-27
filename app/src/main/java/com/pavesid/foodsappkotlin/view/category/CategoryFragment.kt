package com.pavesid.foodsappkotlin.view.category

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.pavesid.foodsappkotlin.R
import com.pavesid.foodsappkotlin.adapter.RecyclerViewMealByCategory
import com.pavesid.foodsappkotlin.model.Meals
import com.pavesid.foodsappkotlin.view.detail.DetailActivity
import com.pavesid.foodsappkotlin.view.main.MainActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_category.progressBar
import kotlinx.android.synthetic.main.fragment_category.textCategory
import kotlinx.android.synthetic.main.item_recycler_meal.*
import java.io.Serializable

class CategoryFragment : Fragment(), CategoryView {
    lateinit var descDialog: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null) {
            textCategory.text = arguments?.getString("EXTRA_DATA_DESC") ?: ""
            Picasso.get().load(arguments?.getString("EXTRA_DATA_IMAGE")).into(imageCategory)
            Picasso.get().load(arguments?.getString("EXTRA_DATA_IMAGE")).into(imageCategoryBg)
            cardCategory.setOnClickListener {
                descDialog.setPositiveButton("CLOSE") { dialog, _ -> dialog.dismiss() }
                descDialog.show()
            }
            descDialog = AlertDialog.Builder(context!!)
                .setTitle(arguments!!.getString("EXTRA_DATA_NAME"))
                .setMessage(arguments!!.getString("EXTRA_DATA_DESC"))
            //declare presenter
            val presenter = CategoryPresenter(this)
            presenter.getMealByCategory(arguments?.getString("EXTRA_DATA_NAME") ?: "")
        }
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    override fun setMeals(meal: List<Meals.Meal>?) {
        val adapter = RecyclerViewMealByCategory(meal ?: listOf(), context)

        recyclerView.layoutManager = GridLayoutManager(context, 2)
        recyclerView.clipToPadding = false
        recyclerView.adapter = adapter

        adapter.notifyDataSetChanged()

        adapter.setOnItemClickListener(object : RecyclerViewMealByCategory.ClickListener {
            override fun onClick(view: View, position: Int) {
//                Toast.makeText(
//                    context,
//                    "meal : " + meal?.get(position)?.getStrMeal(),
//                    Toast.LENGTH_SHORT
//                ).show()

                val intent = Intent(activity, DetailActivity::class.java)
                // add extra data (put to intent)
                intent.putExtra(MainActivity.EXTRA_DETAIL, mealName.text.toString())
                startActivity(intent)
            }
        })
    }

    override fun onErrorLoading(message: String?) {

    }
}