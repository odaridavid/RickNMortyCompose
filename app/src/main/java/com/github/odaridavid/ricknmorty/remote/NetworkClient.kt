package com.github.odaridavid.ricknmorty.remote

import com.apollographql.apollo.ApolloClient
import com.github.odaridavid.ricknmorty.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object NetworkClient {

    val apollo: ApolloClient by lazy {
        ApolloClient.builder()
            .okHttpClient(okHttpClient)
            .serverUrl(BASE_URL)
            .build()
    }

    private const val BASE_URL = "https://rickandmortyapi.com/graphql/"

    private val okHttpClient by lazy {
        val okHttp = OkHttpClient().newBuilder()
            .callTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)

        if (BuildConfig.DEBUG) {
            okHttp.addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                }
            )
        }
        okHttp.build()
    }
}
