package com.example.weatherservice

import com.example.weatherservice.Location
import retrofit2.http.GET
import retrofit2.http.Query

internal interface LocationAPI {
    /*API endpoint to get location data
    @param latitude, longitude, API key
    @return List of Location object
     */
    @GET("reverse")
    suspend fun locationName(@Query("lat") latitude:Double, @Query("lon") longitude:Double, @Query("appid") key:String):List<Location>
}