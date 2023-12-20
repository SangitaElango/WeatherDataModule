package com.example.weatherservice


internal class WeatherRepository {
    private var weatherService:WeatherAPI = WeatherAPIService.getAPIService()
    private var locationService: LocationAPI = LocationNameAPIService.getAPIService()

    /*
    access this function to get weather details by city name and implement the WeatherListener to handle the result
    @param location(city name) as String, object WeatherListener
    @return callback - onWeatherDataReceived (success), callback - onFailure
    */
    suspend fun getWeatherByLocationName(location: String, listener: WeatherListener) = try {
        val weather = weatherService.weatherDetails(location, API_KEY)
        listener.onWeatherDataReceived(weather)
    }
    catch (e: Exception) {
        e.message?.let { listener.onFailure(it) } ?: listener.onFailure("unKnown Exception")
    }

    /*
    access this function to get weather details by latitude and longitude and implement the WeatherListener to handle the result
    @param latitude as Double, longitude as Double, object WeatherListener
    @return callback - onWeatherDataReceived (success), callback - onFailure
    */
    suspend fun getWeatherByLatAndLon(latitude:Double, longitude:Double, listener: WeatherListener) = try {
        val locationList: List<Location> = getLocationName(latitude,longitude)
        getWeatherByLocationName(locationList[0].name,listener)
    } catch (e: Exception) {
        e.message?.let { listener.onFailure(it) } ?: listener.onFailure("unKnown Exception")
    }


    suspend fun getLocationName(latitude:Double, longitude:Double): List<Location> = try {
        val locationList: List<Location>? = locationService.locationName(latitude,longitude,
            API_KEY
        )
        locationList?.let{locationList}?:throw NullPointerException("The provided city list is null.")
    }
    catch (e: Exception) {
        throw e
    }


    companion object {
        //secure key if got more time
        private const val API_KEY = "a82258355ab9d6c9b14a2e84e56bfe54"
    }

}