package com.hemmati.namavatest.di

import org.koin.core.qualifier.named

object Qualifiers {
    val RETROFIT_VIDEO_LIST = named("retrofitVideoList")
    val RETROFIT_VIDEO_PLAYER = named("retrofitVideoPlayer")

    val API_SERVICE_VIDEO_LIST = named("apiServiceVideoList")
    val API_SERVICE_VIDEO_PLAYER = named("apiServiceVideoPlayer")
}