# WeatherService

The WeatherService library provides weather data retrieval functionalities for Android applications.

## Features

1. **getWeatherByLocationName:**
   Access this function to retrieve weather details by passing the city name.

2. **getWeatherByLatAndLon:**
   Access this function to retrieve weather details by passing latitude and longitude.

## Usage

### Integration

1. **Add Library Dependency:**
   Add the WeatherService library to your project's dependencies.
   ```groovy
   implementation 'com.example:weatherservice:1.0.0'

### dependency
1. add Internet Permission. Ensure your app's manifest includes the Internet permission.
2. Add android:usesCleartextTraffic="true" to the <application> element in your app's manifest file to allow clear text traffic.
   ```xml
   <application
    android:usesCleartextTraffic="true">
   </application>

### Security Considerations

It's crucial to **consider security implications** when allowing clear text traffic (`android:usesCleartextTraffic="true"`) in your app's manifest.

> **Note:** Allowing clear text traffic might expose sensitive data to potential security risks. Ensure your backend services **support secure HTTPS connections** to encrypt data transmitted between your app and the server.

**Sensitive data**, such as user credentials or personal information, should **never be transmitted over non-secure (HTTP) connections**. Always prioritize using HTTPS for secure communication.

Make sure to **audit and secure your backend APIs** to guarantee a secure communication channel between your app and the server.

For further security measures, consider implementing additional encryption and authentication mechanisms to safeguard user data.

## Examples
1. Getting Weather by Location Name - call the getWeatherByLocationName inside a coroutineScope/builder
   ```kotlin
   // Example to retrieve weather data by city name
   weatherRepository.getWeatherByLocationName("cityname",object:WeatherListener{
            override fun onWeatherDataReceived(weather: Weather) {
                //utilize weather
            }
            override fun onFailure(errorMessage: String) {
                //handle exception
            }
        })
2. Getting Weather by Latitude and Longitude - call the getWeatherByLatAndLon inside a coroutineScope/builder
   ```kotlin
   // Example to retrieve weather data by latitude and longitude
   weatherRepository.getWeatherByLatAndLon(latitude,longitude,object:WeatherListener{
            override fun onWeatherDataReceived(weather: Weather) {
                weatherData.value = weather
            }
            override fun onFailure(errorMessage: String) {
                Log.d(TAG, "Error data retrieval$errorMessage")
            }
        })

## License
Since I use the WeatherService library internally, I didn't add any License