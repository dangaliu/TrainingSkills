package com.example.trainingskills.utils

sealed class Resource<T>(data: T? = null, message: String? = null) {

    class Success<T>(val data: T) : Resource<T>(data)
    class Error<T>(val message: String) : Resource<T>(message = message)
    class Loading<T> : Resource<T>()
}