package com.hemmati.namavatest.domain.model.videoDetail

data class User(
    val account: String,
    val available_for_hire: Boolean,
    val bio: String,
    val can_work_remotely: Boolean,
    val capabilities: Capabilities,
    val created_time: String,
    val gender: String,
    val link: String,
    val location: String,
    val location_details: LocationDetails,
    val metadata: MetadataX,
    val name: String,
    val pictures: PicturesXXXX,
    val resource_key: String,
    val short_bio: Any,
    val skills: List<Any>,
    val uri: String,
    val websites: List<Any>
)