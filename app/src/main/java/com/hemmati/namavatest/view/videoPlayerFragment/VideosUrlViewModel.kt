package com.hemmati.namavatest.view.videoPlayerFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.namavatest.domain.exeption.ApiError
import com.hemmati.namavatest.domain.model.videoUrlModel.VideoUrlModel
import com.hemmati.namavatest.domain.usecase.GetVideosUrlUseCase
import com.hemmati.namavatest.domain.usecase.base.UseCaseResponse
import com.hemmati.namavatest.view.searchListFragment.VideoListViewModel
import kotlinx.coroutines.cancel

class VideosUrlViewModel(
    private val getVideosUrlUseCase: GetVideosUrlUseCase,
    url: String
) : ViewModel() {
    val videoUrlData = MutableLiveData<VideoUrlModel>()
    val showProgressbar = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    init {
        getVideoDetail(url)
    }

    private fun getVideoDetail(url: String) {
        showProgressbar.value = true
        getVideosUrlUseCase.invoke(
            viewModelScope,
            url,
            object : UseCaseResponse<VideoUrlModel> {
                override fun onSuccess(result: VideoUrlModel) {
                    videoUrlData.value = result
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

    companion object {
        private val TAG = VideoListViewModel::class.java.name
    }

}