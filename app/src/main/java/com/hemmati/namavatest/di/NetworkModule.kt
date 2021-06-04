package com.hemmati.namavatest.di

import com.hemmati.namavatest.BuildConfig
import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoList
import com.hemmati.namavatest.domain.dataAccess.remot.ApiServiceVideoPlayer
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val TIME_OUT = 30L
const val BASE_URL = BuildConfig.BASE_URL
const val BASE_URL_VIDEO_PLAYER = BuildConfig.BASE_URL_VIDEO_PLAYER

val NetworkModule = module {
    single(Qualifiers.RETROFIT_VIDEO_LIST) { createRetrofit(get(), BASE_URL) }
    single(Qualifiers.RETROFIT_VIDEO_PLAYER) { createRetrofit(get(), BASE_URL_VIDEO_PLAYER) }
    single { createRetrofit(get(), BASE_URL) }
    single { createOkHttpClient() }

    single { GsonConverterFactory.create() }

    single(Qualifiers.API_SERVICE_VIDEO_LIST) {
        getKoin().get<Retrofit>(Qualifiers.RETROFIT_VIDEO_LIST)
            .create(ApiServiceVideoList::class.java)
    }

    single(Qualifiers.API_SERVICE_VIDEO_PLAYER) {
        getKoin().get<Retrofit>(Qualifiers.RETROFIT_VIDEO_PLAYER)
            .create(ApiServiceVideoPlayer::class.java)
    }
}

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    HttpLoggingInterceptor.Level.BASIC.also { httpLoggingInterceptor.level = it }
    return OkHttpClient.Builder()
        .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
        .readTimeout(TIME_OUT, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor).build()
}

fun createRetrofit(okHttpClient: OkHttpClient, url: String): Retrofit {
    return Retrofit.Builder()
        .baseUrl(url)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}



