package com.example.weatherservice

import com.example.weatherservice.Weather
import retrofit2.http.GET
import retrofit2.http.Query

internal interface WeatherAPI {
    /*API endpoint to get weather data
    @param city name, API key
    @return weather object
     */

    @GET("weather")
    suspend fun weatherDetails(@Query("q") city:String,@Query("appid") key:String): Weather

}