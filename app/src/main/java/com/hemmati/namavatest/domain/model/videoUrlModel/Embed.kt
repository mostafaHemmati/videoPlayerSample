package com.hemmati.namavatest.domain.model.videoUrlModel

data class Embed(
    val api: Any,
    val app_id: String,
    val autopause: Int,
    val autoplay: Int,
    val color: String,
    val context: String,
    val dnt: Int,
    val editor: Boolean,
    val log_plays: Int,
    val loop: Int,
    val muted: Int,
    val on_site: Int,
    val outro: String,
    val player_id: String,
    val playsinline: Int,
    val quality: Any,
    val settings: Settings,
    val texttrack: String,
    val time: Int,
    val transparent: Int
)