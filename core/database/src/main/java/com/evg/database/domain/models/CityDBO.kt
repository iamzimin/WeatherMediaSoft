package com.evg.database.domain.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CityDBO(
    @PrimaryKey val id: Int,
    val coordLon: Double,
    val coordLat: Double,
    //val country: String,
    //val geoname: Geoname,
    //val langs: List<Lang>,
    val name: String,
    //val stat: Stat,
    //val stations: List<Station>,
    //val zoom: Int
)

/*data class CoordDBO(
    val lon: Double,
    val lat: Double
)*/

/*data class Geoname(
    val cl: String,
    val code: String,
    val parent: Int
)*/

/*data class Lang(
    val de: String?,
    val fa: String?
)*/

/*data class Stat(
    val level: Double,
    val population: Int
)*/

/*
data class Station(
    val id: Int,
    val dist: Int,
    val kf: Int
)
*/
