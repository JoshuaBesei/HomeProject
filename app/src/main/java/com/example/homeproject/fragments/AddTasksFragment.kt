package com.example.homeproject.fragments

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.homeproject.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddTasksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddTasksFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_add_tasks, container, false)
        val mcurrentTime = Calendar.getInstance()
        val year = mcurrentTime.get(Calendar.YEAR)
        val month = mcurrentTime.get(Calendar.MONTH)
        val day = mcurrentTime.get(Calendar.DAY_OF_MONTH)

        val datePicker = context?.let {
            DatePickerDialog(it, object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
                    val selectedDate = v.findViewById<TextView>(R.id.selectedDate)
                    selectedDate.setText(String.format("%s %d / %d / %d", "DUE DATE: ", dayOfMonth, month + 1, year))
                    selectedDate.setTextColor(Color.BLACK)
                }
            }, year, month, day)
        };
        val selectDate = v.findViewById<ImageButton>(R.id.selectDate)
        selectDate.setOnClickListener({ v ->
            datePicker?.show()
        })

        val mPickTimeBtn = v.findViewById<ImageButton>(R.id.selectTime)
        val textView     = v.findViewById<TextView>(R.id.selectedTime)

        val hour = mcurrentTime.get(Calendar.HOUR)
        val minute = mcurrentTime.get(Calendar.MINUTE)
        val timePicker = context?.let {
            TimePickerDialog(it, R.style.CustomDatePickerDialog,  object : TimePickerDialog.OnTimeSetListener {
                override fun onTimeSet(view: TimePicker?, hour: Int, minute: Int) {
                    textView.setText(String.format("%d : %d", hour, minute))
                }
            }, hour, minute, true)
        };
        mPickTimeBtn.setOnClickListener({ v ->

            timePicker?.show()
            timePicker?.getButton(DatePickerDialog.BUTTON_NEGATIVE)?.setBackgroundColor(Color.LTGRAY);
            timePicker?.getButton(DatePickerDialog.BUTTON_POSITIVE)?.setBackgroundColor(Color.BLUE);
        })

        return v
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddTasksFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AddTasksFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}