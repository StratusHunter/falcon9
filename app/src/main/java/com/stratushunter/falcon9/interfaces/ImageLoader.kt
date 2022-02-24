package com.stratushunter.falcon9.interfaces

import android.content.Context
import android.widget.ImageView

interface ImageLoader {

    fun loadImage(url: String?, imageView: ImageView)
}