package com.example.trainingskills.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainingskills.api.AppClient
import com.example.trainingskills.models.LoginRequest
import com.example.trainingskills.models.LoginResponse
import com.example.trainingskills.utils.Resource
import com.example.trainingskills.utils.TOKEN
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SignInViewModel : ViewModel() {

    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>> = _loginResponse

    @SuppressLint("CheckResult")
    fun signIn(loginRequest: LoginRequest) {
        AppClient.retrofit.login(loginRequest)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result ->
                    TOKEN = result.data.token
                    _loginResponse.value = Resource.Success(result)
                },
                { error -> _loginResponse.value = Resource.Error(error.message ?: "Error") }
            )
    }
}