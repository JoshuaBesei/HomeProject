package com.example.homeproject

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homeproject.fragments.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val account = AccountFragment()
        val leaderboards = LeaderBoardsFragment()
        val completedTasks = CompletedTasksFragment()
        val addTasks = AddTasksFragment()
        var checked = "High"

        makeCurrentFragment(homeFragment)

        val bottomNavigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val buttonHigh = findViewById<Button>(R.id.High)
        val buttonLow = findViewById<Button>(R.id.Low)

        bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.account -> makeCurrentFragment(account)
                R.id.leaderboards -> makeCurrentFragment(leaderboards)
                R.id.completedTasks -> makeCurrentFragment(completedTasks)
                R.id.addTasks -> makeCurrentFragment(addTasks)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}