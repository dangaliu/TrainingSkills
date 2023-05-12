package com.example.trainingskills.models

data class TasksResponse(
    val success: Boolean,
    val data: List<TaskData>,
    val message: String
)
