package com.stratushunter.falcon9.classes.response

import com.google.gson.annotations.SerializedName

data class SpaceXResponse(val docs: List<Launch>, @SerializedName("nextPage") val nextPage: Int?)