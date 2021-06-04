package com.hemmati.namavatest.domain.dataAccess.remot

import com.hemmati.namavatest.domain.model.videoDetail.VideoDetail
import com.hemmati.namavatest.domain.model.videoUrlModel.VideoUrlModel
import com.hemmati.namavatest.domain.model.videos.Video
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceVideoList {
    @GET("/videos")
    suspend fun getVideos(
        @Query("query") query: String,
        @Query("per_page") perPage: Int,
        @Header("Authorization") authHeader: String
    ): Video

    @GET("/videos/{video_id}")
    suspend fun getVideoDetail(
        @Path("video_id") videoId: String,
        @Header("Authorization") authHeader: String
    ): VideoDetail

}