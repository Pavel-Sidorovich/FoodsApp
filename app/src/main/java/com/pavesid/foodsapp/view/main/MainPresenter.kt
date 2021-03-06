package com.pavesid.foodsapp.view.main

import android.util.Log
import com.pavesid.foodsapp.Common
import com.pavesid.foodsapp.model.Categories
import com.pavesid.foodsapp.model.Meals
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var view: MainView) {

    fun getMeals() {
        view.showLoading()

        val mealsCall: Call<Meals> = Common.newClient.getMeal()
        mealsCall.enqueue(object : Callback<Meals> {
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
                    response.body()
                    view.setMeal(response.body()?.getMeals())

                } else {
                    // Show an error message if the conditions are not met
                    view.onErrorLoading(response.message())
                }
            }
        })
    }

    fun getSearchMeal(string: String) {
        view.showLoading()

        val mealsCall: Call<Meals> = Common.newClient.getMealByName(string)
        mealsCall.enqueue(object : Callback<Meals> {
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
                    view.setMeal(response.body()?.getMeals())

                } else {
                    // Show an error message if the conditions are not met
                    view.onErrorLoading(response.message())
                }
            }
        })
    }

    fun getCategories() {
        view.showLoading()

        val categoriesCall: Call<Categories> = Common.newClient.getCategories()

        categoriesCall.enqueue(object : Callback<Categories>{
            override fun onFailure(call: Call<Categories>, t: Throwable) {
                view.hideLoading()

                view.onErrorLoading(t.localizedMessage)
            }

            override fun onResponse(call: Call<Categories>, response: Response<Categories>) {
                view.hideLoading()

                if (response.isSuccessful && response.body() != null) {
                    /*
                     * Receive the result
                     * input the results obtained into the setMeals() behavior
                     * and enter response.body() to the parameter
                     */
                    view.setCategory(response.body()?.getCategories())

                } else {
                    // Show an error message if the conditions are not met
                    view.onErrorLoading(response.message())
                }
            }

        })
    }
}