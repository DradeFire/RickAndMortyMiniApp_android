package com.example.rickandmortyminiapp.api.retrofit

import com.example.rickandmortyminiapp.consts.Consts.RICK_AND_MORTY_BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstanceApi{

    private val retrofitRAM by lazy {
        Retrofit.Builder()
            .baseUrl(RICK_AND_MORTY_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiRAM: RetrofitApi by lazy {
        retrofitRAM.create(RetrofitApi::class.java)
    }

}