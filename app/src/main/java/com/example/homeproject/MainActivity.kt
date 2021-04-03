package com.example.homeproject

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.homeproject.R.id.High
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
        val toggleButtonHigh = findViewById<ToggleButton>(R.id.High)
        val toggleButtonLow = findViewById<ToggleButton>(R.id.Low)

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

        /*
        toggleButtonHigh.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checked = "High"
            }
        }*/

        /*
        toggleButtonLow.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                checked = "Low"
            }
        }*/

        val timeZones = resources.getStringArray(R.array.TimeZones)

        val spinner = findViewById<Spinner>(R.id.timeZoneSpinner)
        if (spinner != null) {
            val adapter = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, timeZones)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>,
                                            view: View, position: Int, id: Long) {
                    Toast.makeText(this@MainActivity,
                        getString(R.string.selected_item) + " " +
                                "" + timeZones[position], Toast.LENGTH_SHORT).show()
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    // write code to perform some action
                }
            }
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragment)
            commit()
        }

}