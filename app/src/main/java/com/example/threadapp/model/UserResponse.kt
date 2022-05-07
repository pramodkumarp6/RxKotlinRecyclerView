package com.example.threadapp.model

import com.example.threadapp.model.User
import com.google.gson.annotations.SerializedName

data class UserResponse(
    val error: Boolean,
    @SerializedName("users")
    val users: List<User>
)
