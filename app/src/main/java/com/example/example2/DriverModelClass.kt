package com.example.example2

//Creating a data model class for Drivers
data class Drivers(
    val drivers: List<DriverModelClass>
)

data class DriverModelClass(
    val image: String,
    val name: String,
    val team: String,
    val country: String,
    val podiums: Int,
    val points: Int,
    val grand_prix_entered: Int,
    val world_championships: Int,
    val highest_grid_position: Int,
    val birth: Birth
)

data class Birth(
    val date: String,
    val place: String
)
