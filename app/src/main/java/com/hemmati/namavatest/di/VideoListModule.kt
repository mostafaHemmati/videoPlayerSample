package com.hemmati.namavatest.di

import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoList
import com.hemmati.namavatest.domain.dataAccess.repository.GetVideoListRepositoryImpl
import com.hemmati.namavatest.domain.dataAccess.repository.VideoListRepository
import com.hemmati.namavatest.domain.usecase.GetVideoListUseCase
import com.hemmati.namavatest.view.searchListFragment.VideoListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val VideosListModule = module {

    viewModel { VideoListViewModel(get()) }

    single { createGetVideoListUseCase(videoListRepository = get()) }

    single { createVideoListRepository(apiServiceVideoList = get(Qualifiers.API_SERVICE_VIDEO_LIST)) }

}

fun createVideoListRepository(apiServiceVideoList: ApiServiceVideoList): VideoListRepository {
    return GetVideoListRepositoryImpl(apiServiceVideoList)
}

fun createGetVideoListUseCase(videoListRepository: VideoListRepository): GetVideoListUseCase {
    return GetVideoListUseCase(videoListRepository)
}