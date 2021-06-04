package com.hemmati.namavatest.domain.dataAccess.repository

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoPlayer
import com.hemmati.namavatest.domain.model.videoUrlModel.VideoUrlModel

interface VideosUrlRepository {

    suspend fun getVideoUrl(
        url: String
    ): VideoUrlModel
}

class GetVideosUrlRepositoryImpl(
    private val apiServiceVideoList: ApiServiceVideoPlayer
) : VideosUrlRepository {
    override suspend fun getVideoUrl(url: String): VideoUrlModel {
        return apiServiceVideoList.getVideoURL(url)
    }


}