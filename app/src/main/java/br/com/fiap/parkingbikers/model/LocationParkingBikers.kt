package br.com.fiap.parkingbikers.model

data class LocationParkingBikers(
    val id: Int,
    val title: String,
    val latitude: Double,
    val longitude: Double,
    val endereco: String,
    val vagasCapacidade: Int,
    val iconResourceId: Int,

)
