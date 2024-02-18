package com.hyper.medicineapp.common.util

import android.icu.util.Calendar

fun getGreetingsBasedOnTime(): String {
    val calendar = Calendar.getInstance()

    val greeting = when (calendar.get(Calendar.HOUR_OF_DAY)) {
        in 0..11 -> "Good morning"
        in 12..16 -> "Good afternoon"
        else -> "Good evening"
    }

    return greeting
}