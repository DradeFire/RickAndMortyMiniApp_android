package com.example.rickandmortyminiapp.api.repository

import com.example.rickandmortyminiapp.api.retrofit.RetrofitInstanceApi

class Repository {

    suspend fun getAllChars() = RetrofitInstanceApi.apiRAM.getAllChars()

}