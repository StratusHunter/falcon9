package com.stratushunter.falcon9.classes.response

import android.content.Context
import android.text.format.DateFormat
import java.util.*

data class Launch(
    val id: String,
    val name: String,
    val success: Boolean,
    val dateUnix: Long,
    val links: Links) {

    fun readableDate(context: Context): String = DateFormat.getMediumDateFormat(context).format(Date(dateUnix * 1000L))
}
