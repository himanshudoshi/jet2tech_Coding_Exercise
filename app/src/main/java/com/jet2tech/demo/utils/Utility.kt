package com.jet2tech.demo.utils

import android.app.Activity
import android.content.Context
import android.util.DisplayMetrics
import android.widget.ImageView
import com.squareup.picasso.Picasso

fun Activity.getHeightforView(height: Float): Int {

    val displaymetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displaymetrics)
    val screenWidth = displaymetrics.widthPixels
    val screenHeight = displaymetrics.heightPixels
    val windowHeight = (screenHeight * height).toInt()
    return windowHeight
}

fun Activity.getWidthforView(width: Float): Int {

    val displaymetrics = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(displaymetrics)
    val screenWidth = displaymetrics.widthPixels
    val screenHeight = displaymetrics.heightPixels
    val windowWidth = (screenWidth * width).toInt()
    return windowWidth

}

fun loadImage(image: String, imageView: ImageView, context: Context) {
    Picasso.get()
        .load(image)
        .into(imageView)
}
