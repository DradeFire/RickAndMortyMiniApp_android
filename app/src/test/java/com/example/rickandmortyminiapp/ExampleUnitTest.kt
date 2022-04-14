package com.example.rickandmortyminiapp

import android.util.Log
import com.example.rickandmortyminiapp.api.repository.Repository
import com.example.rickandmortyminiapp.api.retrofit.model.AllCharsModel
import kotlinx.coroutines.*
import org.junit.Test

class ExampleUnitTest {

    @OptIn(DelicateCoroutinesApi::class)
    @Test
    fun api_test() {
        val rep = Repository()
        var value_obj: AllCharsModel? = null
        GlobalScope.launch {
            value_obj = async { rep.getAllChars().body()!! }.await()
        }
        val name = value_obj?.results!![0].name
        Log.d("Ex", name)
    }
}