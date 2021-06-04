package com.hemmati.namavatest.domain.model.videos

data class Pictures(
    val active: Boolean,
    val default_picture: Boolean,
    val resource_key: String,
    val sizes: List<SizeX>,
    val type: String,
    val uri: String
)