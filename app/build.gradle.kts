plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.google.gms.google.services)
    alias(libs.plugins.google.firebase.crashlytics)
    alias(libs.plugins.hilt.android)
    alias(libs.plugins.devtools.ksp)
    id("kotlin-kapt")
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
            isMinifyEnabled = true
            isShrinkResources = true
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
     /* sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8 */
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

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.navigation.fragment.ktx)
    implementation(libs.navigation.ui.ktx)
    implementation(project(":library"))
    implementation(project(":scan_qr"))
    implementation(project(":core:designsystem"))

    implementation("io.coil-kt:coil:1.4.0")
    implementation("com.github.Victor2018:easypermissions:v1.1.0")
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)

    // Hilt for testing
    // Dagger Hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    //debugImplementation libs.hilt.android.testing
    //kaptAndroidTest libs.hilt.android.compiler
    // Room components
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    annotationProcessor(libs.room.compiler)

     /* Timber */
    implementation("com.jakewharton.timber:timber:5.0.1")
    /*{
        exclude module: "play-services-ads-identifier"
        exclude module: "play-services-measurement"
        exclude module: "play-services-measurement-sdk"
        exclude module: "play-services-measurement-api"
    }*/
    testImplementation(libs.junit)
    //androidTestImplementation(libs.junit)
    //androidTestImplementation(libs.espresso.core)
}