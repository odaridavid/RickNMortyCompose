object Dependencies {
    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.stlibVersion}"
        const val coroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.coroutinesVersion}"
    }

    object Jetpack {
        const val coreKtx = "androidx.core:core-ktx:${Versions.Jetpack.coreKtxVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.Jetpack.appCompatVersion}"
        const val viewmodelKtx =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.Jetpack.lifecycleKtxVersion}"
        const val livedataKtx =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.Jetpack.lifecycleKtxVersion}"
        const val activityKtx =
            "androidx.activity:activity-ktx:${Versions.Jetpack.activityKtxVersion}"
        const val hiltAndroid = "com.google.dagger:hilt-android:${Versions.Jetpack.hiltVersion}"
        const val hiltLifecycleCompiler =
            "androidx.hilt:hilt-compiler:${Versions.Jetpack.hiltLifecycleVersion}"
        const val hiltAndroidCompiler =
            "com.google.dagger:hilt-android-compiler:${Versions.Jetpack.hiltVersion}"
        const val hiltLifecycleViewModel =
            "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.Jetpack.hiltLifecycleVersion}"

        object Compose {
            const val foundation =
                "androidx.compose.foundation:foundation:${Versions.Jetpack.composeVersion}"
            const val material =
                "androidx.compose.material:material:${Versions.Jetpack.composeVersion}"
            const val ui = "androidx.compose.ui:ui:${Versions.Jetpack.composeVersion}"
            const val animation =
                "androidx.compose.animation:animation:${Versions.Jetpack.composeVersion}"
            const val uiTooling = "androidx.ui:ui-tooling:${Versions.Jetpack.composeVersion}"
        }
    }

    object Material {
        const val material =
            "com.google.android.material:material:${Versions.Material.materialVersion}"
    }

    object ThirdParty {
        const val apolloRuntime =
            "com.apollographql.apollo:apollo-runtime:${Versions.ThirdParty.apolloVersion}"
        const val apolloCoroutines =
            "com.apollographql.apollo:apollo-coroutines-support:${Versions.ThirdParty.apolloVersion}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.ThirdParty.okhttpVersion}"
        const val okhttpLoggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Versions.ThirdParty.okhttpVersion}"
        const val leakCanary =
            "com.squareup.leakcanary:leakcanary-android:${Versions.ThirdParty.leakCanaryVersion}"
        const val coil = "io.coil-kt:coil:${Versions.ThirdParty.coilVersion}"
    }
}
