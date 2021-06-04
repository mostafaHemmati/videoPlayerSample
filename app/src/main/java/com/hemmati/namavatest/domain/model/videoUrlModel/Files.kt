package com.hemmati.namavatest.domain.model.videoUrlModel

data class Files(
    val dash: Dash,
    val hls: Hls,
    val progressive: List<Progressive>
)