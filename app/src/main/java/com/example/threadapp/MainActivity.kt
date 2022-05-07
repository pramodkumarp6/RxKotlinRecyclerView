package com.example.threadapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.threadapp.adapter.MainAdapter
import com.example.threadapp.databinding.ActivityMainBinding
import com.example.threadapp.model.User
import com.example.threadapp.model.UserResponse
import com.example.threadapp.viewmodel.MainViewModel
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var mainViewModel: MainViewModel
    private lateinit var mainAdapter: MainAdapter

    private val users: List<User>?  = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainBinding.recler.setLayoutManager(LinearLayoutManager(this))

        mainAdapter = MainAdapter()


        dataClick()
        dataView()

    }

    fun dataView() {

       /* val observable: Observable<UserResponse?>? = RetrofitClient.getInstance()!!.getApi()!!
            .userData()
            ?.subscribeOn(Schedulers.io())
            ?.observeOn(AndroidSchedulers.mainThread())
        var subscribe = observable?.subscribe(object : io.reactivex.Observer<UserResponse?> {
            override fun onSubscribe(d: Disposable) {
                TODO("Not yet implemented")
            }

            override fun onNext(userResponse: UserResponse) {
                // data.setValue(t)
                // mainAdapter.notifyDataSetChanged();
                val gson = GsonBuilder().setPrettyPrinting().create()
                Log.e("MainActivity", gson.toJson(userResponse))

            }

            override fun onError(e: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onComplete() {
                TODO("Not yet implemented")
            }

        })*/
    }

    fun dataClick() {
        mainViewModel.getUserDetails().observe(
            this
        ) { userResponse ->
            val response: UserResponse = userResponse
            if (!response.error) {
                val users: List<User> = response.users


                mainAdapter.setUser(users)
                mainBinding.recler.adapter = mainAdapter
                mainAdapter.notifyDataSetChanged();

                val gson = GsonBuilder().setPrettyPrinting().create()
                Log.e("MainActivity", gson.toJson(users))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}