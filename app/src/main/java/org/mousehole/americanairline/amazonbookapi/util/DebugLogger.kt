package org.mousehole.americanairline.amazonbookapi.util

import android.util.Log

object DebugLogger {
    const val TAG = "TAG_X"

    fun debugLogger(message : String) {
        Log.d(TAG, message)
    }

    fun errorLogger(message : String, t : Throwable) {
        Log.e(TAG, message, t)
    }
}