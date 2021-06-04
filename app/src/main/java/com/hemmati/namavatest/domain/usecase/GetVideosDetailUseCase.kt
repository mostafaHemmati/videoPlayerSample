package com.hemmati.namavatest.domain.usecase

import com.hemmati.namavatest.domain.dataAccess.repository.VideosDetailRepository
import com.hemmati.namavatest.domain.model.videoDetail.VideoDetail
import com.hemmati.namavatest.domain.usecase.base.UseCase

class GetVideosDetailUseCase constructor(
    private val videosDetailRepository: VideosDetailRepository
) : UseCase<VideoDetail, List<Any>>() {

    override suspend fun run(params: List<Any>?): VideoDetail {
        return videosDetailRepository.getVideoDetail(
            params?.get(0) as String,
            params[1] as String
        )
    }

}