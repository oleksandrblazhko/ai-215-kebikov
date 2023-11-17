package com.example.watercleaningapp

import androidx.appcompat.app.AlertDialog

fun methodUsage() {
    val activity = MainActivity()
    val builder = AlertDialog.Builder(activity)
    when(activity.setModeTemperature(
       true, false,false, "15"
    )) {
        MainActivity.SUCCESS -> {
            builder.setTitle("Параметри успішно встановлені")
            builder.setPositiveButton("OK") { _, _ -> }
            builder.create().show()
        }
    }
    when(activity.setModeTemperature(
        true, true,false, "15"
    )) {
        MainActivity.Unknown_mode_ERROR -> {
            builder.setTitle("Неправильний режим")
            builder.setPositiveButton("OK") { ignored1, ignored2 -> }
            builder.create().show()
        }
    }
    when(activity.setModeTemperature(
        true, false,false, "15.5"
    )) {
        MainActivity.DATA_ERROR -> {
            builder.setTitle("Неправильні дані")
            builder.setPositiveButton("OK") { _, _ -> }
            builder.create().show()
        }
    }
}