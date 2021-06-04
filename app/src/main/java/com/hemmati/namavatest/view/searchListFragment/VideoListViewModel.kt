package com.hemmati.namavatest.view.searchListFragment

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hemmati.namavatest.BuildConfig
import com.hemmati.namavatest.domain.exeption.ApiError
import com.hemmati.namavatest.domain.model.videos.Video
import com.hemmati.namavatest.domain.usecase.GetVideoListUseCase
import com.hemmati.namavatest.domain.usecase.base.UseCaseResponse
import kotlinx.coroutines.cancel

class VideoListViewModel constructor(private val getVideoListUseCase: GetVideoListUseCase) :
    ViewModel() {
    val videoListData = MutableLiveData<Video>()
    val showProgressbar = MutableLiveData<Boolean>()
    val queryTextNullOrEmpty = MutableLiveData<Boolean>()
    val messageData = MutableLiveData<String>()

    fun getPosts(query: String) {
        if (query.trim().isEmpty()) {
            queryTextNullOrEmpty.value = true
            return
        } else
            queryTextNullOrEmpty.value = false
        showProgressbar.value = true

        getVideoListUseCase.invoke(
            viewModelScope, listOf(query, 10, BuildConfig.TOKEN),
            object : UseCaseResponse<Video> {
                override fun onSuccess(result: Video) {
                    videoListData.value = result
                    showProgressbar.value = false
                }

                override fun onError(apiError: ApiError?) {
                    messageData.value = apiError?.getErrorMessage()
                    showProgressbar.value = false
                }
            },
        )
    }

    override fun onCleared() {
        viewModelScope.cancel()
        super.onCleared()
    }

    companion object {
        private val TAG = VideoListViewModel::class.java.name
    }

}