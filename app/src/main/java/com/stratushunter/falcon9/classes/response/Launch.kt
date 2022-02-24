package com.stratushunter.falcon9.classes.response

data class Launch(
    val id: String,
    val name: String,
    val success: Boolean,
    val dateUnix: Long,
    val links: Links)
