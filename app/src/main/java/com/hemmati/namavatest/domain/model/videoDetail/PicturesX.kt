package com.hemmati.namavatest.domain.model.videoDetail

data class PicturesX(
    val active: Boolean,
    val default_picture: Boolean,
    val resource_key: String,
    val sizes: List<Size>,
    val type: String,
    val uri: String
)