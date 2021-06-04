package com.hemmati.namavatest.domain.model.videos

data class Category(
    val icon: Icon,
    val is_deprecated: Boolean,
    val last_video_featured_time: String,
    val link: String,
    val metadata: Metadata,
    val name: String,
    val parent: Any,
    val pictures: Pictures,
    val resource_key: String,
    val subcategories: List<Subcategory>,
    val top_level: Boolean,
    val uri: String
)