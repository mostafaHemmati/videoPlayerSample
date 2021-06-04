package com.hemmati.namavatest.di

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoList
import com.hemmati.namavatest.domain.dataAccess.repository.GetVideosDetailRepositoryImpl
import com.hemmati.namavatest.domain.dataAccess.repository.VideosDetailRepository
import com.hemmati.namavatest.domain.usecase.GetVideosDetailUseCase
import com.hemmati.namavatest.view.videoDetailFragment.VideosDetailViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VideosDetailModule = module {

    viewModel { (videoId: String) -> VideosDetailViewModel(get(), videoId) }

    single { createGetVideosDetailUseCase(videosDetailRepository = get()) }

    single { createVideosDetailRepository(apiServiceVideoList = get(Qualifiers.API_SERVICE_VIDEO_LIST)) }
}

fun createVideosDetailRepository(apiServiceVideoList: ApiServiceVideoList): VideosDetailRepository {
    return GetVideosDetailRepositoryImpl(apiServiceVideoList)
}

fun createGetVideosDetailUseCase(videosDetailRepository: VideosDetailRepository): GetVideosDetailUseCase {
    return GetVideosDetailUseCase(videosDetailRepository)
}