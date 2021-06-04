package com.hemmati.namavatest.domain.model.videoDetail

data class Metadata(
    val connections: Connections,
    val interactions: Interactions,
    val is_screen_record: Boolean,
    val is_vimeo_create: Boolean
)