package com.example.list_compose.image

import android.widget.ImageView

interface ImageLoader {
    fun loadImage(imageView: ImageView,url:String)

    fun loadImage()
}