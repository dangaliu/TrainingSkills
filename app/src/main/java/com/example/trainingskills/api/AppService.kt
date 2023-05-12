package com.example.trainingskills.api

import com.example.trainingskills.models.LoginRequest
import com.example.trainingskills.models.LoginResponse
import com.example.trainingskills.models.TasksResponse
import io.reactivex.rxjava3.core.Single
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface AppService {

    @POST("login")
    fun login(@Body loginRequest: LoginRequest): Single<LoginResponse>

    @GET("task")
    fun getTasks(@Header("Authorization") token: String): Single<TasksResponse>
}