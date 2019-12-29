package com.pavesid.foodsappkotlin.api

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.pavesid.foodsappkotlin.MyApplication
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class FoodClient {
    private val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"

    val cacheSize = (5 * 1024 * 1024).toLong()
    val myCache = Cache(MyApplication.appContext!!.cacheDir, cacheSize)
    private var retrofit: Retrofit? = null

    companion object

    fun getClient(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(provideOkHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        }
        return retrofit ?: throw Exception("Retrofit not initializing")
    }

    private fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addNetworkInterceptor(provideLoggingInterceptor())
            .build()
    }

    val provideOkHttpClient =
            OkHttpClient.Builder()
                    // Specify the cache we created earlier.
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .cache(myCache)
                    // Add an Interceptor to the OkHttpClient.
                    .addInterceptor { chain ->

                        // Get the request from the chain.
                        var request = chain.request()

                        /*
                    *  Leveraging the advantage of using Kotlin,
                    *  we initialize the request and change its header depending on whether
                    *  the device is connected to Internet or not.
                    */
                        request = if (checkNetworkState(MyApplication.appContext!!))
                        /*
                    *  If there is Internet, get the cache that was stored 5 seconds ago.
                    *  If the cache is older than 5 seconds, then discard it,
                    *  and indicate an error in fetching the response.
                    *  The 'max-age' attribute is responsible for this behavior.
                    */
                            request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                        else
                        /*
                    *  If there is no Internet, get the cache that was stored 7 days ago.
                    *  If the cache is older than 7 days, then discard it,
                    *  and indicate an error in fetching the response.
                    *  The 'max-stale' attribute is responsible for this behavior.
                    *  The 'only-if-cached' attribute indicates to not retrieve new data; fetch the cache only instead.
                    */
                            request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                        // End of if-else statement

                        // Add the modified request to the chain.
                        chain.proceed(request)
                    }
                    .build()

    private fun checkNetworkState(context: Context): Boolean {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val nw = connectivityManager.activeNetwork ?: return false
            val actNw = connectivityManager.getNetworkCapabilities(nw) ?: return false
            return when {
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> true
                actNw.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> true
                else -> false
            }
        } else {
            val nwInfo = connectivityManager.activeNetworkInfo ?: return false
            return nwInfo.isConnected
        }
    }
}