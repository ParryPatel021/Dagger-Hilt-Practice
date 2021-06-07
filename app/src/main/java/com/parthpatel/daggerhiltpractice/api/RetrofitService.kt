package com.parthpatel.daggerhiltpractice.api

import com.parthpatel.daggerhiltpractice.model.UserModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface RetrofitService {

    //users/1
    @GET("users/{id}")
    fun getUserById(@Path("id") id: Int): Call<UserModel>

}