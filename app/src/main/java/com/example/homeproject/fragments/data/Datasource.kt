package com.example.homeproject.fragments.data

import com.example.homeproject.R
import com.example.homeproject.fragments.tasks.Tasks

class Datasource {
    fun loadTasks(): List<Tasks> {
        return listOf<Tasks>(
            Tasks(R.string.task1, R.string.description1),
            Tasks(R.string.task2, R.string.description2),
            Tasks(R.string.task3, R.string.description3),
            Tasks(R.string.task4, R.string.description4),
            Tasks(R.string.task5, R.string.description5)
        )
    }
}