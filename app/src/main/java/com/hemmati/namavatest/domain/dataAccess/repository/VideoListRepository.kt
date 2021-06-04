package com.hemmati.namavatest.domain.dataAccess.repository

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoList
import com.hemmati.namavatest.domain.model.videos.Video


interface VideoListRepository {

    suspend fun getVideos(
        query: String,
        perPage: Int,
        authHeader: String
    ): Video
}

class GetVideoListRepositoryImpl(private val apiServiceVideoList: ApiServiceVideoList) : VideoListRepository {

    override suspend fun getVideos(query: String, perPage: Int, authHeader: String): Video {
        return apiServiceVideoList.getVideos(query, perPage, authHeader)
    }


}