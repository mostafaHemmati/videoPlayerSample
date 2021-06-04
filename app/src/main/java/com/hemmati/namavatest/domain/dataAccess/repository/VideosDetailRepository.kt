package com.hemmati.namavatest.domain.dataAccess.repository

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoList
import com.hemmati.namavatest.domain.model.videoDetail.VideoDetail

interface VideosDetailRepository {

    suspend fun getVideoDetail(
        videoId: String,
        authHeader: String
    ): VideoDetail
}

class GetVideosDetailRepositoryImpl(private val apiServiceVideoList: ApiServiceVideoList) :
    VideosDetailRepository {
    override suspend fun getVideoDetail(videoId: String, authHeader: String): VideoDetail {
        return apiServiceVideoList.getVideoDetail(videoId, authHeader)
    }


}