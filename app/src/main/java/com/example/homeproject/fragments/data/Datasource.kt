package com.example.homeproject.fragments.data

import com.example.homeproject.R
import com.example.homeproject.fragments.tasks.Tasks

class Datasource {
    fun loadTasks(): List<Tasks> {
        return listOf<Tasks>(
            Tasks(R.string.task1, R.string.description1, R.string.time1),
            Tasks(R.string.task2, R.string.description2, R.string.time2),
            Tasks(R.string.task3, R.string.description3, R.string.time3),
            Tasks(R.string.task4, R.string.description4, R.string.time4),
            Tasks(R.string.task5, R.string.description5, R.string.time5)
        )
    }
}