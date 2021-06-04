package com.hemmati.namavatest.domain.model.videoDetail

data class Connections(
    val comments: Comments,
    val credits: Credits,
    val likes: Likes,
    val pictures: Pictures,
    val recommendations: Recommendations,
    val related: Any,
    val texttracks: Texttracks
)