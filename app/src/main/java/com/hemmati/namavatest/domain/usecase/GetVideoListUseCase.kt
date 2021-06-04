package com.hemmati.namavatest.domain.usecase

import com.hemmati.namavatest.domain.dataAccess.repository.VideoListRepository
import com.hemmati.namavatest.domain.model.videos.Video
import com.hemmati.namavatest.domain.usecase.base.UseCase


class GetVideoListUseCase constructor(
    private val videoListRepository: VideoListRepository
) : UseCase<Video, List<Any>>() {

    override suspend fun run(params: List<Any>?): Video {
        return videoListRepository.getVideos(
            params?.get(0) as String, params[1] as Int,
            params[2] as String
        )
    }

}