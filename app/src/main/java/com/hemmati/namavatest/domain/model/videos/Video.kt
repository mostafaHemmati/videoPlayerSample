package com.hemmati.namavatest.domain.model.videos

data class Video(
    val `data`: List<Data>,
    val page: Int,
    val paging: Paging,
    val per_page: Int,
    val total: Int
)