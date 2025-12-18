plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pawnshopmanager"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.pawnshopmanager"
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
}

dependencies {
    // DÒNG NÀY BẠN THÊM VÀO LÀ ĐÚNG, HÃY GIỮ LẠI
    implementation("androidx.cardview:cardview:1.0.0")

    // KHÔNG CẦN THÊM DÒNG "material:1.10.0"
    // VÌ NÓ ĐÃ CÓ SẴN Ở DƯỚI RỒI (libs.material)

    implementation(libs.appcompat)
    implementation(libs.material) // <-- Thư viện Material gốc của bạn nằm đây
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}