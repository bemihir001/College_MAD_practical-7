package com.example.mihir_018_p_7

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CalendarView
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*


@Suppress("DEPRECATION")
class TimeActivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.time_picking_activity)

        lateinit var btnSetAlarm: Button
        lateinit var timePicker: TimePicker


        title = "KotlinApp"
        val time_picker: TimePicker = findViewById(R.id.time_picker)
        val btn_confirm: Button = findViewById(R.id.btn_confirm)
        val calendar: Calendar = Calendar.getInstance()

        btn_confirm.setOnClickListener {

            if (Build.VERSION.SDK_INT >= 23) {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    timePicker.hour,
                    timePicker.minute,
                )
            } else {
                calendar.set(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH),
                    timePicker.currentHour,
                    timePicker.currentMinute,
                )
            }

            //setAlarm(Calender.millisTime)
        }
    }

    private fun setAlarm(millisTime: Long, str: String) {

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, MyAlarm::class.java)
        val pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0)
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            millisTime,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )
        Toast.makeText(this, "Alarm is set", Toast.LENGTH_SHORT).show()
    }

    private class MyAlarm : BroadcastReceiver() {
        override fun onReceive(
            context: Context,
            intent: Intent
        ) {
            Log.d("Alarm Bell", "Alarm just fired")
        }
    }
}
