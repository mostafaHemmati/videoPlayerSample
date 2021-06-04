package com.hemmati.namavatest.domain.model.videoUrlModel

data class Dash(
    val cdns: Cdns,
    val default_cdn: String,
    val separate_av: Boolean,
    val streams: List<Stream>,
    val streams_avc: List<StreamsAvc>
)