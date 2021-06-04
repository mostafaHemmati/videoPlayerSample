package com.hemmati.namavatest.domain.model.videos

data class PicturesXX(
    val active: Boolean,
    val default_picture: Boolean,
    val resource_key: String,
    val sizes: List<SizeXX>,
    val type: String,
    val uri: String
)