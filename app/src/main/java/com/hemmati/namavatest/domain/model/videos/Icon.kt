package com.hemmati.namavatest.domain.model.videos

data class Icon(
    val active: Boolean,
    val default_picture: Boolean,
    val resource_key: String,
    val sizes: List<Size>,
    val type: String,
    val uri: String
)