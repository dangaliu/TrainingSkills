package com.example.trainingskills.models

data class LoginResponse(
    val success: Boolean,
    val data: Data,
    val message: String
)