package com.example.weatherservice

import com.google.gson.annotations.SerializedName

data class Condition(val main:String,val icon:String)

data class Temperature(val temp:Double,@SerializedName("temp_min")val tempMin:Double,@SerializedName("temp_max")val tempMax:Double)

data class Weather(@SerializedName("weather")val condition:List<Condition>?=null, @SerializedName("main")val temperature: Temperature?=null)
