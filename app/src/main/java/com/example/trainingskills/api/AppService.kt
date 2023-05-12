package com.example.trainingskills.api

import com.example.trainingskills.models.LoginRequest
import com.example.trainingskills.models.LoginResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.POST

interface AppService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>
}