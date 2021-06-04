package com.hemmati.namavatest.domain.model.videoUrlModel

data class Video(
    val allow_hd: Int,
    val bypass_token: String,
    val default_to_hd: Int,
    val duration: Int,
    val embed_code: String,
    val embed_permission: String,
    val fps: Double,
    val hd: Int,
    val height: Int,
    val id: Int,
    val lang: String,
    val live_event: Any,
    val logo_url: String,
    val owner: Owner,
    val privacy: String,
    val rating: Rating,
    val share_url: String,
    val spatial: Int,
    val thumbs: Thumbs,
    val title: String,
    val unlisted_hash: Any,
    val url: String,
    val version: Version,
    val width: Int
)