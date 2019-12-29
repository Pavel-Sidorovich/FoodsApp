package com.pavesid.foodsappkotlin.view.category

import android.util.Log
import com.pavesid.foodsappkotlin.Common
import com.pavesid.foodsappkotlin.model.Meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryPresenter(val view: CategoryView) {
    fun getMealByCategory(category: String) {
        view.showLoading()

        val mealsCall: Call<Meals> = Common.newClient.getMealsByCategory(category)
        mealsCall.enqueue(object : Callback<Meals>{
            override fun onFailure(call: Call<Meals>, t: Throwable) {
                view.hideLoading()

                view.onErrorLoading(t.localizedMessage)
            }

            override fun onResponse(call: Call<Meals>, response: Response<Meals>) {
                view.hideLoading()

                if (response.isSuccessful && response.body() != null) {
                    /*
                     * Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */
                    view.setMeals(response.body()?.getMeals())

                } else {
                    // Show an error message if the conditions are not met
                    view.onErrorLoading(response.message())
                }
            }

        })

    }
}