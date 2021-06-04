package com.hemmati.namavatest.domain.model.videos

data class PicturesXXX(
    val active: Boolean,
    val default_picture: Boolean,
    val resource_key: String,
    val sizes: List<SizeXXX>,
    val type: String,
    val uri: String
)