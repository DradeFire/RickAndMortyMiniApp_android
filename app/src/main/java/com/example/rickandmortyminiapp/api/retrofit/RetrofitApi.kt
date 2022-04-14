package com.example.rickandmortyminiapp.api.retrofit

import com.example.rickandmortyminiapp.api.retrofit.model.AllCharsModel
import com.example.rickandmortyminiapp.consts.Consts.ALL_CHARACTERS_QUERY
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitApi {

    @GET(ALL_CHARACTERS_QUERY)
    suspend fun getAllChars(): Response<AllCharsModel>

}