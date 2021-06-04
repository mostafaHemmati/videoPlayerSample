package com.hemmati.namavatest.domain.model.videoUrlModel

data class Progressive(
    val cdn: String,
    val fps: Int,
    val height: Int,
    val id: String,
    val mime: String,
    val origin: String,
    val profile: Int,
    val quality: String,
    val url: String,
    val width: Int
)