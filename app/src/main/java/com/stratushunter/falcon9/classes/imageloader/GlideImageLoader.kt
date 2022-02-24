package com.stratushunter.falcon9.classes.imageloader

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.stratushunter.falcon9.interfaces.ImageLoader

class GlideImageLoader(context: Context) : ImageLoader {

    private val glide = Glide.with(context)

    //region ImageLoader
    override fun loadImage(url: String?, imageView: ImageView) {

        if (url == null) {

            imageView.setImageDrawable(null)
            return
        }

        glide.load(url).into(imageView)
    }
    //endregion
}