package com.example.trainingskills.ui.viewmodels

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.trainingskills.api.AppClient
import com.example.trainingskills.models.TasksResponse
import com.example.trainingskills.utils.Resource
import com.example.trainingskills.utils.TOKEN
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel : ViewModel() {

    private val _tasks: MutableLiveData<Resource<TasksResponse>> = MutableLiveData()
    val tasks: LiveData<Resource<TasksResponse>> = _tasks

    @SuppressLint("CheckResult")
    fun getTasks() {
        AppClient.retrofit.getTasks("Bearer $TOKEN")
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(
                { result -> _tasks.value = Resource.Success(result) },
                { error -> _tasks.value = Resource.Error(error.message ?: "Error") }
            )
    }

}