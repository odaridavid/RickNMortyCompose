plugins {
    id(Plugins.androidApplication)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.apollo).version(Versions.ThirdParty.apolloVersion)
    id(Plugins.hilt)
}

android {
    compileSdkVersion(Config.compileSdkVersion)
    buildToolsVersion(Config.buildToolsVersion)

    defaultConfig {
        applicationId = Config.applicationId
        minSdkVersion(Config.minSdkVersion)
        targetSdkVersion(Config.targetSdkVersion)
        versionCode = Config.versionCode
        versionName = Config.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.Jetpack.composeVersion
        kotlinCompilerVersion = Versions.Kotlin.stlibVersion
    }
}

dependencies {

    // region Kotlin

    implementation(Dependencies.Kotlin.stdLib)
    implementation(Dependencies.Kotlin.coroutinesCore)

    // endregion

    // region Jetpack

    implementation(Dependencies.Jetpack.coreKtx)
    implementation(Dependencies.Jetpack.appCompat)
    implementation(Dependencies.Jetpack.viewmodelKtx)
    implementation(Dependencies.Jetpack.livedataKtx)
    implementation(Dependencies.Jetpack.activityKtx)
    implementation(Dependencies.Jetpack.hiltAndroid)
    implementation(Dependencies.Jetpack.hiltLifecycleViewModel)
    implementation(Dependencies.Jetpack.Compose.foundation)
    implementation(Dependencies.Jetpack.Compose.material)
    implementation(Dependencies.Jetpack.Compose.ui)
    implementation(Dependencies.Jetpack.Compose.animation)
    implementation(Dependencies.Jetpack.Compose.uiTooling)
    kapt(Dependencies.Jetpack.hiltLifecycleCompiler)
    kapt(Dependencies.Jetpack.hiltAndroidCompiler)

    // endregion

    // region Material

    implementation(Dependencies.Material.material)

    // endregion

    // region Third Party

    implementation(Dependencies.ThirdParty.apolloRuntime)
    implementation(Dependencies.ThirdParty.apolloCoroutines)
    implementation(Dependencies.ThirdParty.okhttp)
    implementation(Dependencies.ThirdParty.okhttpLoggingInterceptor)
    debugImplementation(Dependencies.ThirdParty.leakCanary)
    implementation(Dependencies.ThirdParty.coil)

    // endregion
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
            freeCompilerArgs =
                freeCompilerArgs + listOf("-Xallow-jvm-ir-dependencies", "-Xskip-prerelease-check")
        }
    }
}

apollo {
    generateKotlinModels.set(true)
}
