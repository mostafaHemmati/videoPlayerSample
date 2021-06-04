package com.hemmati.namavatest.di

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoPlayer
import com.hemmati.namavatest.domain.dataAccess.repository.GetVideosUrlRepositoryImpl
import com.hemmati.namavatest.domain.dataAccess.repository.VideosUrlRepository
import com.hemmati.namavatest.domain.usecase.GetVideosUrlUseCase
import com.hemmati.namavatest.view.videoPlayerFragment.VideosUrlViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VideosUrlModule = module {

    viewModel { (url: String) -> VideosUrlViewModel(getVideosUrlUseCase = get(), url = url) }

    single { createGetVideosUrlUseCase(videosUrlRepository = get()) }

    single { createVideosUrlRepository(apiServiceVideoPlayer = get(Qualifiers.API_SERVICE_VIDEO_PLAYER)) }

}

fun createVideosUrlRepository(apiServiceVideoPlayer: ApiServiceVideoPlayer): VideosUrlRepository {
    return GetVideosUrlRepositoryImpl(apiServiceVideoPlayer)
}

fun createGetVideosUrlUseCase(videosUrlRepository: VideosUrlRepository): GetVideosUrlUseCase {
    return GetVideosUrlUseCase(videosUrlRepository)
}