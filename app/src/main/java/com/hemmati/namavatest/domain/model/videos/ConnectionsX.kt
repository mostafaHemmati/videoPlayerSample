package com.hemmati.namavatest.domain.model.videos

data class ConnectionsX(
    val comments: Comments,
    val credits: Credits,
    val likes: Likes,
    val pictures: PicturesX,
    val recommendations: Recommendations,
    val related: Related,
    val texttracks: Texttracks
)