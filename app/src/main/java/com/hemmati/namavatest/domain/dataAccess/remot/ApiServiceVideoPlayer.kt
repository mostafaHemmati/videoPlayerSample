package com.hemmati.namavatest.domain.dataAccess.remot

import com.hemmati.namavatest.domain.model.videoUrlModel.VideoUrlModel
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServiceVideoPlayer {
    @GET("/video/{id}/config")
    suspend fun getVideoURL(@Path("id") videoId: String): VideoUrlModel
}