package com.example.trainingskills.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.trainingskills.databinding.ItemTaskBinding
import com.example.trainingskills.models.TaskData
import com.example.trainingskills.models.TasksResponse

class TaskAdapter(
    val tasks: List<TaskData>,
    var onItemClick: () -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return tasks.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        with(holder.binding) {
            tvTitle.text = task.title
            tvDuration.text = "${task.estimated_duration} min."
            tvDeadline.text = task.deadline
            tvStatus.text = task.status.title
            tvBottomStatus.text = task.status.title
            root.setOnClickListener { onItemClick() }
        }
    }
}