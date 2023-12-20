package com.example.weatherservice


import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class WeatherAPIServiceTest {
//sample test case to test a function. would implement more test cases if got time and also would mock the api service
    @Test
    fun testApiService_success() = runTest {
        //Mock the Repo class if got more time
        val weatherRepositoryObj = WeatherRepository()
        // Mocking the behavior of the ApiService

            // Perform the test
        weatherRepositoryObj.getWeatherByLocationName("London", object : WeatherListener {
            override fun onWeatherDataReceived(weatherData: Weather) {
                assertNotEquals(null,weatherData)
            }
            override fun onFailure(message: String) {
            }
        })
    }
    @Test
    fun testApiService_failure() = runTest {

        val weatherRepositoryObj = WeatherRepository()

        // Perform the test
        weatherRepositoryObj.getWeatherByLocationName("", object : WeatherListener {
            override fun onWeatherDataReceived(weatherData: Weather) {

            }
            override fun onFailure(message: String) {
                assertEquals("HTTP 400 Bad Request",message)

            }
        })
    }


}