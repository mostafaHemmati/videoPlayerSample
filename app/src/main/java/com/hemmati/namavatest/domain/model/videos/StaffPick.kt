package com.hemmati.namavatest.domain.model.videos

data class StaffPick(
    val best_of_the_month: Boolean,
    val best_of_the_year: Boolean,
    val normal: Boolean,
    val premiere: Boolean
)