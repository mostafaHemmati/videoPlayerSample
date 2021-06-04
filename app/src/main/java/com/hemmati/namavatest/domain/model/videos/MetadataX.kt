package com.hemmati.namavatest.domain.model.videos

data class MetadataX(
    val connections: ConnectionsX,
    val interactions: Interactions,
    val is_screen_record: Boolean,
    val is_vimeo_create: Boolean
)