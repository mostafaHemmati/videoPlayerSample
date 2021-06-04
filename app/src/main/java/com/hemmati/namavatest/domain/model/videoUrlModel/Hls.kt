package com.hemmati.namavatest.domain.model.videoUrlModel

data class Hls(
    val cdns: CdnsX,
    val default_cdn: String,
    val separate_av: Boolean
)