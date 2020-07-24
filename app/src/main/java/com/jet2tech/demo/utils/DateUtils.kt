package com.jet2tech.demo.utils

import java.text.ParseException
import java.text.SimpleDateFormat

private const val SECOND_MILLIS = 1000
private const val MINUTE_MILLIS = 60 * SECOND_MILLIS
private const val HOUR_MILLIS = 60 * MINUTE_MILLIS
private const val DAY_MILLIS = 24 * HOUR_MILLIS

fun String.getTimeAgo(): String {
    //Date pattern 2020-04-17T12:13:44.575Z
    var timeAgo = ""
    val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    try {
        var time = format.parse(this)?.time

        if (time!! < 1000000000000L) {
            time *= 1000
        }

        val now = System.currentTimeMillis()
        if (time > now || time <= 0) {
            timeAgo =  ""
        }

        val diff = now - time;
        timeAgo =  when {
            diff < MINUTE_MILLIS -> {
                "just now";
            }
            diff < 2 * MINUTE_MILLIS -> {
                "a minute ago";
            }
            diff < 50 * MINUTE_MILLIS -> {
                "${diff / MINUTE_MILLIS} min";
            }
            diff < 90 * MINUTE_MILLIS -> {
                "an hour ago";
            }
            diff < 24 * HOUR_MILLIS -> {
                "${diff / HOUR_MILLIS} hrs";
            }
            else -> {
                "${(diff / DAY_MILLIS)} days";
            }
        }
    } catch (e: ParseException) {
        e.printStackTrace()
    }

    return timeAgo
}