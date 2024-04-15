package com.tarkalabs.tarkaui.extentions

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity

fun Context.scanForActivity(): AppCompatActivity? {
  return when (this) {
    is AppCompatActivity -> this
    is ContextWrapper -> baseContext.scanForActivity()
    else -> null
  }
}