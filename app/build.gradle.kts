plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
}

android {
    namespace = "uz.alisoft.office"
    compileSdk = 35

    defaultConfig {
        applicationId = "uz.alisoft.office"
        minSdk = 24
        targetSdk = 35
        versionCode = 3
        versionName = "1.0.2"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            isShrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    applicationVariants.configureEach  {
        val variant = this
        outputs.configureEach {
            // APK faylini nomlash
            (this as com.android.build.gradle.internal.api.ApkVariantOutputImpl).apply {
                outputFileName = "wps-office-${variant.versionName}-${variant.versionCode}.apk"
            }
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }

   /* key store password :wps_office
   *  key alias :key_wps_office
   *  key password :wps_office */

}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(project(":library"))

    implementation("io.coil-kt:coil:1.4.0")
    implementation("com.github.Victor2018:easypermissions:v1.1.0")
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

    /* Timber */
    implementation("com.jakewharton.timber:timber:5.0.1")
    //implementation("com.google.firebase:firebase-crashlytics:18.3.6")
    //implementation("com.google.firebase:firebase-analytics:21.2.1")
    /*{
        exclude module: "play-services-ads-identifier"
        exclude module: "play-services-measurement"
        exclude module: "play-services-measurement-sdk"
        exclude module: "play-services-measurement-api"
    }*/
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}