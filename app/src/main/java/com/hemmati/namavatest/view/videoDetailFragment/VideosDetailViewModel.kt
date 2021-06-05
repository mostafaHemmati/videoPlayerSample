package com.hemmati.namavatest.view.videoDetailFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.namavatest.BuildConfig
import com.hemmati.namavatest.domain.exeption.ApiError
import com.hemmati.namavatest.domain.model.videoDetail.VideoDetail
import com.hemmati.namavatest.domain.usecase.GetVideosDetailUseCase
import com.hemmati.namavatest.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class VideosDetailViewModel(
    private val getVideosDetailUseCase: GetVideosDetailUseCase,
    videoId: String
) :
    ViewModel() {
    val videoDetailData = MutableLiveData<VideoDetail>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    init {
        getVideoDetail(videoId)
    }

    private fun getVideoDetail(videoId: String) {
        showProgressbar.value = true
        getVideosDetailUseCase.invoke(
            viewModelScope,
            listOf(videoId, BuildConfig.TOKEN),
            object : UseCaseResponse<VideoDetail> {
                override fun onSuccess(result: VideoDetail) {
                    videoDetailData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }

            })
    }


    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }


}