package com.pavesid.foodsappkotlin.view.detail

import com.pavesid.foodsappkotlin.Common
import com.pavesid.foodsappkotlin.model.Meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailPresenter(val view: DetailView) {

    fun getMealByName(mealName: String) {

        view.showLoading()

        val meal = Common.newClient.getMealByName(mealName)
        meal.enqueue(object : Callback<Meals> {
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
                    view.setMeal(response.body()?.getMeals()?.get(0))

                } else {
                    // Show an error message if the conditions are not met
                    view.onErrorLoading(response.message())
                }
            }

        })
    }
}