package com.example.geonho.openweathermapapi

data class Coord(val lon: Double,
                 val lat: Double)

data class Weather(val id:Int,
                   val main:String?,
                   val description:String?,
                   val icon:String?)

data class Main(val temp:String?
                ,val pressure:Double
                ,val humidity:Double
                ,val temp_min:Double
                ,val temp_max:Double)

data class Wind(val speed:Double
                ,val deg:Int)

data class Clouds(val all:Int)

data class Sys(val type:Int,
               val id:Int,
               val message:Double,
               val country:String,
               val sunrice:Long,
               val sunset:Long)

data class ApiInfo(val coord: Coord,
                   val weather: List<Weather>,
                   val base:String,
                   val main: Main,
                   val visibility:Long,
                   val wind:Wind,
                   val clouds: Clouds,
                   val dt:Long,
                   val sys: Sys,
                   val id:Long,
                   val name:String,
                   val cod:Int)
