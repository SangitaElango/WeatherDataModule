package com.example.weatherservice

interface WeatherListener {
        /*
        WeatherListener provides function to implement call back
        onWeatherDataReceived - to handle success
        @param - weather object
        onFailure - to handle failure
        @param - Error message as String
         */
        fun onWeatherDataReceived(weather: Weather)
        fun onFailure(errorMessage: String)
}