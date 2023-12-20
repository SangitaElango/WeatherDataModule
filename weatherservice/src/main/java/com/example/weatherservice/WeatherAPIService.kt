package com.example.weatherservice

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal object WeatherAPIService {

    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

    /*
     getAPIService creates WeatherAPI service using retrofit
     @return WeatherAPI
     */
    fun getAPIService(): WeatherAPI {
        var service: WeatherAPI
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)

        val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
            GsonConverterFactory.create()).client(httpClient.build()).build()
        service = retrofit.create(WeatherAPI::class.java)
        return service
    }
}