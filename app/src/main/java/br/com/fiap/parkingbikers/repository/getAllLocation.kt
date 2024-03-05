package br.com.fiap.parkingbikers.repository

import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.model.LocationParkingBikers

fun getAllLocation(): List<LocationParkingBikers> {
    return listOf(
        LocationParkingBikers(id = 1, title = "Estação Praça da Sé", latitude = -23.549866, longitude = -46.6333734, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 2, title = "Estação Paulista", latitude = -23.5552763, longitude = -46.6633263, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 3, title = "Estação República", latitude = -23.5490777, longitude = -46.6562152, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 4, title = "Estação Consolação", latitude = -23.5577619, longitude = -46.6686209, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 5, title = "Estação Tiradentes", latitude = -23.5308419, longitude = -46.6420228, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 6, title = "Estação Tatuapé", latitude = -23.5402779, longitude = -46.5789991, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 7, title = "Estação Barra Funda", latitude = -23.5253789, longitude = -46.5789991, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 8, title = "Estação Santana", latitude = -23.5025856, longitude = -46.627318, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 9, title = "Estação Vila Mariana", latitude = -23.5894894, longitude = -46.6370245, iconResourceId = R.drawable.pin),
        LocationParkingBikers(id = 10, title = "Estação Mooca", latitude = -23.5582426, longitude = -46.6101551, iconResourceId = R.drawable.pin),
    )
}
