package br.com.fiap.parkingbikers.repository

import br.com.fiap.parkingbikers.R
import br.com.fiap.parkingbikers.model.LocationParkingBikers

fun getAllLocation(): List<LocationParkingBikers> {
    return listOf(
        LocationParkingBikers(
            id = 1,
            title = "Praça da Sé",
            latitude = -23.549866,
            longitude = -46.6333734,
            endereco = "Praça da Sé, S/N",
            vagasCapacidade = 60,
            vagasDisponiveis = 35,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 2,
            title = "Paulista",
            latitude = -23.5552763,
            longitude = -46.6633263,
            endereco = "R. da Consolação, 2367",
            vagasCapacidade = 80,
            vagasDisponiveis = 46,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 3,
            title = "República",
            latitude = -23.5490777,
            longitude = -46.6562152,
            endereco = "Praça da República, 229",
            vagasCapacidade = 50,
            vagasDisponiveis = 25,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 4,
            title = "Consolação",
            latitude = -23.5577619,
            longitude = -46.6686209,
            endereco = "Av. Paulista, 2163",
            vagasCapacidade = 70,
            vagasDisponiveis = 45,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 5,
            title = "Tiradentes",
            latitude = -23.5308419,
            longitude = -46.6420228,
            endereco = "Av. Tiradentes, 551",
            vagasCapacidade = 60,
            vagasDisponiveis = 45,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 6,
            title = "Tatuapé",
            latitude = -23.5402779,
            longitude = -46.5789991,
            endereco = "R. Melo Freire, S/N",
            vagasCapacidade = 80,
            vagasDisponiveis = 15,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 7,
            title = "Barra Funda",
            latitude = -23.5255594,
            longitude = -46.6699527,
            endereco = "R. Bento Teobaldo Ferraz, 119",
            vagasCapacidade = 60,
            vagasDisponiveis = 22,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 8,
            title = "Santana",
            latitude = -23.5025856,
            longitude = -46.627318,
            endereco = "Av. Cruzeiro do Sul, 3173",
            vagasCapacidade = 40,
            vagasDisponiveis = 10,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 9,
            title = "Vila Mariana",
            latitude = -23.5894894,
            longitude = -46.6370245,
            endereco = "Av. Prof. Noé Azevedo, 255",
            vagasCapacidade = 40,
            vagasDisponiveis = 25,
            iconResourceId = R.drawable.pin
        ),
        LocationParkingBikers(
            id = 10,
            title = "Mooca",
            latitude = -23.5582426,
            longitude = -46.6101551,
            endereco = "Av. Presidente Wilson, 483",
            vagasCapacidade = 40,
            vagasDisponiveis = 25,
            iconResourceId = R.drawable.pin
        ),
    )
}
