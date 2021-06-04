package com.hemmati.namavatest.domain.model.videoUrlModel

data class VideoUrlModel(
    val cdn_url: String,
    val embed: Embed,
    val player_url: String,
    val request: Request,
    val user: User,
    val video: Video,
    val view: Int,
    val vimeo_api_url: String,
    val vimeo_url: String
)