plugins {
    alias(libs.plugins.android.application)
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.example.mytodolist"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mytodolist"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // --- SỬA LỖI Ở ĐÂY ---
    // 1. Đổi "def" thành "val"
    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    // 2. Đổi "annotationProcessor" thành "kapt"
    kapt("androidx.room:room-compiler:$room_version")
    // ---------------------

    // (Lưu ý: Bạn đang khai báo 2 dòng này 2 lần. Tôi đã xóa các dòng bị trùng)
    // implementation("com.google.android.material:material:1.12.0")
    // implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // Các thư viện AndroidX và Material (từ libs)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Thư viện testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}