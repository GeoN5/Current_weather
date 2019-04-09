package com.example.geonho.openweathermapapi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService{

    @GET("/data/2.5/weather")
    fun getWeather(@Query("lat")lat:Double,
                   @Query("lon")lon:Double,
                   @Query("units")units:String,
                   @Query("appid")appid:String
                   ): Call<ApiInfo>
}