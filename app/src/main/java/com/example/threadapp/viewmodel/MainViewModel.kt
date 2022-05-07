package com.example.threadapp.viewmodel

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.threadapp.model.User
import com.example.threadapp.model.UserResponse
import com.example.threadapp.repository.MainRepository

class MainViewModel:ViewModel() {

    private lateinit var mainRepository: MainRepository
     val data:LiveData<List<User>> get() = data

    fun getUserDetails(): LiveData<UserResponse> {
        mainRepository = MainRepository()
       // loadUser()
        return mainRepository.dataView()

    }

    private  fun loadUser(){




    }
}