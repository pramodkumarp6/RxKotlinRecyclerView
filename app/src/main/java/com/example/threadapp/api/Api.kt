package com.example.threadapp.api

import com.example.threadapp.model.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface Api {


    @GET("/simple/public/allusers")
    fun userData(): Observable<UserResponse?>
}