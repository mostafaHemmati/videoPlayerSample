package com.hemmati.namavatest.domain.model.videoUrlModel

data class Request(
    val ab_tests: AbTests,
    val build: Build,
    val client: Client,
    val cookie: Cookie,
    val cookie_domain: String,
    val country: String,
    val currency: String,
    val expires: Int,
    val file_codecs: FileCodecs,
    val files: Files,
    val flags: Flags,
    val gc_debug: GcDebug,
    val lang: String,
    val referrer: Any,
    val sentry: Sentry,
    val session: String,
    val signature: String,
    val timestamp: Int,
    val urls: Urls
)