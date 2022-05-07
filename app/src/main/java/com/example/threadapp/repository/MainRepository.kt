package com.example.threadapp.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.threadapp.api.RetrofitClient.apiService
import com.example.threadapp.model.UserResponse
import com.google.gson.GsonBuilder
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainRepository {
    private val data = MutableLiveData<UserResponse>()

    fun dataView(): MutableLiveData<UserResponse> {
        val  observable: Observable<UserResponse?> = apiService.userData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
             observable.subscribe(object : Observer<UserResponse?> {
            override fun onSubscribe(d: Disposable) {
                Log.e(Thread.currentThread().name, "1")

            }

            override fun onNext(response: UserResponse) {

                data.value = response

                Log.e(Thread.currentThread().name, "1")


                val gson = GsonBuilder().setPrettyPrinting().create()
                Log.e("MainRepository", gson.toJson(response))

            }

            override fun onError(e: Throwable) {
                Log.e(Thread.currentThread().name, "1")

            }

            override fun onComplete() {


            }

        })
        return data
    }
}













