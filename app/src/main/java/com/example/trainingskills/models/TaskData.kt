package com.example.trainingskills.models

data class TaskData(
    val id: Int,
    val title: String,
    val user_id: Int,
    val description_url: String,
    val actual_duration: Int,
    val deadline: String,
    val estimated_duration: Int,
    val status_id: Int,
    val status: Status
)
