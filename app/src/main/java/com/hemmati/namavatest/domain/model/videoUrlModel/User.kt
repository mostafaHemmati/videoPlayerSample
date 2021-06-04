package com.hemmati.namavatest.domain.model.videoUrlModel

data class User(
    val account_type: String,
    val id: Int,
    val liked: Int,
    val logged_in: Int,
    val mod: Any,
    val owner: Int,
    val team_id: Int,
    val team_origin_user_id: Int,
    val vimeo_api_client_token: String,
    val vimeo_api_interaction_tokens: Any,
    val watch_later: Int
)