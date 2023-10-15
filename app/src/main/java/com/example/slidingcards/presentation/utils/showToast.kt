package com.example.slidingcards.presentation.utils

import android.content.Context
import android.widget.Toast

fun Context.showToast(msg: String) {
	Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
}