package com.pavesid.foodsappkotlin.view.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pavesid.foodsappkotlin.R
import com.pavesid.foodsappkotlin.model.Meals
import com.pavesid.foodsappkotlin.view.main.MainActivity
import kotlinx.android.synthetic.main.activity_detail.*
import android.content.Intent
import com.squareup.picasso.Picasso
import android.net.Uri
import android.os.Build
import android.view.Menu
import android.view.MenuItem


class DetailActivity : AppCompatActivity(), DetailView {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val mealName: String? = intent.getStringExtra(MainActivity.EXTRA_DETAIL)
        val presenter = DetailPresenter(this)
        presenter.getMealByName(mealName ?: "")
    }

    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        progressBar.visibility = View.INVISIBLE
    }

    private fun setupActionBar() {
        setSupportActionBar(toolbar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            collapsing_toolbar.setContentScrimColor(resources.getColor(R.color.colorWhite, theme))
            collapsing_toolbar.setCollapsedTitleTextColor(
                resources.getColor(
                    R.color.colorPrimary,
                    theme
                )
            )
            collapsing_toolbar.setExpandedTitleColor(resources.getColor(R.color.colorWhite, theme))
        } else {
            collapsing_toolbar.setContentScrimColor(resources.getColor(R.color.colorWhite))
            collapsing_toolbar.setCollapsedTitleTextColor(resources.getColor(R.color.colorPrimary))
            collapsing_toolbar.setExpandedTitleColor(resources.getColor(R.color.colorWhite))
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

//    private fun setupColorActionBarIcon(favoriteItemColor: Drawable) {
//        appbar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { _, verticalOffset ->
//            if (collapsing_toolbar.height + verticalOffset < 2 * ViewCompat.getMinimumHeight(
//                    collapsing_toolbar
//                )
//            ) {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                        if (toolbar.navigationIcon != null)
//                            toolbar.navigationIcon?.colorFilter = BlendModeColorFilter(
//                                resources.getColor(
//                                    R.color.colorPrimary,
//                                    theme
//                                ), BlendMode.SRC_ATOP
//                            )
//                        favoriteItemColor.mutate().colorFilter = BlendModeColorFilter(
//                            resources.getColor(R.color.colorPrimary, theme),
//                            BlendMode.SRC_ATOP
//                        )
//                    } else {
//                        if (toolbar.navigationIcon != null)
//                            toolbar.navigationIcon?.setColorFilter(
//                                resources.getColor(R.color.colorPrimary, theme),
//                                PorterDuff.Mode.SRC_ATOP
//                            )
//                        favoriteItemColor.mutate().setColorFilter(
//                            resources.getColor(R.color.colorPrimary, theme),
//                            PorterDuff.Mode.SRC_ATOP
//                        )
//                    }
//                } else {
//                    if (toolbar.navigationIcon != null)
//                        toolbar.navigationIcon?.setColorFilter(
//                            resources.getColor(R.color.colorPrimary),
//                            PorterDuff.Mode.SRC_ATOP
//                        )
//                    favoriteItemColor.mutate().setColorFilter(
//                        resources.getColor(R.color.colorPrimary),
//                        PorterDuff.Mode.SRC_ATOP
//                    )
//                }
//
//            } else {
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//                        if (toolbar.navigationIcon != null)
//                            toolbar.navigationIcon?.colorFilter = BlendModeColorFilter(
//                                resources.getColor(
//                                    R.color.colorWhite,
//                                    theme
//                                ), BlendMode.SRC_ATOP
//                            )
//                        favoriteItemColor.mutate().colorFilter = BlendModeColorFilter(
//                            resources.getColor(
//                                R.color.colorWhite,
//                                theme
//                            ), BlendMode.SRC_ATOP
//                        )
//                    } else {
//                        if (toolbar.navigationIcon != null)
//                            toolbar.navigationIcon?.setColorFilter(
//                                resources.getColor(R.color.colorWhite, theme),
//                                PorterDuff.Mode.SRC_ATOP
//                            )
//                        favoriteItemColor.mutate().setColorFilter(
//                            resources.getColor(R.color.colorWhite, theme),
//                            PorterDuff.Mode.SRC_ATOP
//                        )
//                    }
//                } else {
//                    if (toolbar.navigationIcon != null)
//                        toolbar.navigationIcon?.setColorFilter(
//                            resources.getColor(R.color.colorWhite),
//                            PorterDuff.Mode.SRC_ATOP
//                        )
//                    favoriteItemColor.mutate().setColorFilter(
//                        resources.getColor(R.color.colorWhite),
//                        PorterDuff.Mode.SRC_ATOP)
//                }
//            }
//        })
//    }
//
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        menuInflater.inflate(R.menu.menu_detail, menu)
//        val favoriteItem = menu.findItem(R.id.favorite)
//        val favoriteItemColor = favoriteItem.icon
//        setupColorActionBarIcon(favoriteItemColor)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun setMeal(meal: Meals.Meal?) {
        Picasso.get().load(meal?.getStrMealThumb()).into(mealThumb)
        collapsing_toolbar.title = meal?.getStrMeal()

        category.text = meal?.getStrCategory()

        country.text = meal?.getStrArea()

        instructions.text = meal?.getStrInstructions()

        setupActionBar()

        if (meal?.getStrIngredient1()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient1())
        }

        if (meal?.getStrIngredient2()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient2())
        }

        if (meal?.getStrIngredient3()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient3())
        }

        if (meal?.getStrIngredient4()?.isNotEmpty() == true) {

            ingredient.append("\n \u2022 " + meal.getStrIngredient4())

        }

        if (meal?.getStrIngredient5()?.isNotEmpty() == true) {

            ingredient.append("\n \u2022 " + meal.getStrIngredient5())

        }

        if (meal?.getStrIngredient6()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient6())
        }

        if (meal?.getStrIngredient7()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient7())
        }

        if (meal?.getStrIngredient8()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient8())
        }

        if (meal?.getStrIngredient9()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient9())
        }

        if (meal?.getStrIngredient10()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient10())
        }

        if (meal?.getStrIngredient11()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient11())
        }

        if (meal?.getStrIngredient12()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient12())
        }

        if (meal?.getStrIngredient13()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient13())
        }

        if (meal?.getStrIngredient14()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient14())
        }

        if (meal?.getStrIngredient15()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient15())
        }

        if (meal?.getStrIngredient16()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient16())
        }

        if (meal?.getStrIngredient17()?.isNotEmpty() == true) {

            ingredient.append("\n \u2022 " + meal.getStrIngredient17())

        }

        if (meal?.getStrIngredient18()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient18())
        }

        if (meal?.getStrIngredient19()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient19())
        }

        if (meal?.getStrIngredient20()?.isNotEmpty() == true) {
            ingredient.append("\n \u2022 " + meal.getStrIngredient20())
        }



        if (meal?.getStrMeasure1()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure1()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure1())
        }

        if (meal?.getStrMeasure2()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure2()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure2())
        }

        if (meal?.getStrMeasure3()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure3()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure3())
        }

        if (meal?.getStrMeasure4()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure4()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure4())
        }

        if (meal?.getStrMeasure5()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure5()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure5())
        }

        if (meal?.getStrMeasure6()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure6()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure6())
        }

        if (meal?.getStrMeasure7()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure7()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure7())
        }

        if (meal?.getStrMeasure8()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure8()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure8())
        }

        if (meal?.getStrMeasure9()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure9()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure9())
        }

        if (meal?.getStrMeasure10()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure10()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure10())
        }

        if (meal?.getStrMeasure11()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure11()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure11())
        }

        if (meal?.getStrMeasure12()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure12()?.get(0) ?: ' '
            )
        ) {

            measure.append("\n : " + meal.getStrMeasure12())

        }

        if (meal?.getStrMeasure13()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure13()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure13())
        }

        if (meal?.getStrMeasure14()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure14()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure14())
        }

        if (meal?.getStrMeasure15()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure15()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure15())
        }

        if (meal?.getStrMeasure16()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure16()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure16())
        }

        if (meal?.getStrMeasure17()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure17()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure17())
        }

        if (meal?.getStrMeasure18()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure18()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure18())
        }

        if (meal?.getStrMeasure19()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure19()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure19())
        }

        if (meal?.getStrMeasure20()?.isNotEmpty() == true && !Character.isWhitespace(
                meal.getStrMeasure20()?.get(0) ?: ' '
            )
        ) {
            measure.append("\n : " + meal.getStrMeasure20())
        }

        youtube.setOnClickListener {
            val intentYoutube = Intent(Intent.ACTION_VIEW)
            intentYoutube.data = Uri.parse(meal?.getStrYoutube())
            startActivity(intentYoutube)
        }

        source.setOnClickListener {
            val intentSource = Intent(Intent.ACTION_VIEW)
            intentSource.data = Uri.parse(meal?.getStrSource())
            startActivity(intentSource)
        }
    }

    override fun onErrorLoading(message: String?) {

    }
}
