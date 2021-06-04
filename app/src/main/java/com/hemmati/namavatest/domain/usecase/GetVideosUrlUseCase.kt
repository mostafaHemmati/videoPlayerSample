package com.hemmati.namavatest.domain.usecase

import com.hemmati.namavatest.domain.dataAccess.repository.VideosUrlRepository
import com.hemmati.namavatest.domain.model.videoUrlModel.VideoUrlModel
import com.hemmati.namavatest.domain.usecase.base.UseCase

class GetVideosUrlUseCase constructor(
    private val videosUrlRepository: VideosUrlRepository
) : UseCase<VideoUrlModel, Any?>() {

    override suspend fun run(params: Any?): VideoUrlModel {
        return videosUrlRepository.getVideoUrl(params.toString())
    }

}