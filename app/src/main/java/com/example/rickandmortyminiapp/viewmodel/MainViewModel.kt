package com.example.rickandmortyminiapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortyminiapp.api.repository.Repository
import com.example.rickandmortyminiapp.api.retrofit.model.AllCharsModel
import com.example.rickandmortyminiapp.api.retrofit.model.Result
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel: ViewModel() {

    var character: Result? = null

    private val repository: Repository by lazy {
        Repository()
    }
    val allChars: MutableLiveData<Response<AllCharsModel>> = MutableLiveData()

    fun getChars(){
        viewModelScope.launch {
            allChars.value = repository.getAllChars()
        }
    }

}