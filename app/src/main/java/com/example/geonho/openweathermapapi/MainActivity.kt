package com.example.geonho.openweathermapapi

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build()!!

    val weatherService = retrofit.create(WeatherService::class.java)!!

    var lon:Double=0.0
    var lat:Double=0.0
    lateinit var call: Call<ApiInfo>
    lateinit var locationManager : LocationManager

    val mLocationManager:LocationListener=object :LocationListener{
        override fun onLocationChanged(location: Location) {
            lon=location.longitude
            lat=location.latitude
            Log.d("test","lat : ${location.latitude} lon : ${location.longitude}")
            call = weatherService.getWeather(lat,lon,"metric","271658afc7d2e742895d027ffe764b47")
            loadData()
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {

        }

        override fun onProviderEnabled(provider: String?) {

        }

        override fun onProviderDisabled(provider: String?) {

        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        updateLocation()

        refreshButton.setOnClickListener{
            updateLocation()
        }
    }
}
