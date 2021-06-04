package com.hemmati.namavatest.domain.model.videos

data class Privacy(
    val add: Boolean,
    val comments: String,
    val download: Boolean,
    val embed: String,
    val view: String
)