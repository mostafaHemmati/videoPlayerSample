package com.hemmati.namavatest.domain.model.videos

data class Badges(
    val hdr: Boolean,
    val live: Live,
    val staff_pick: StaffPick,
    val vod: Boolean,
    val weekend_challenge: Boolean
)