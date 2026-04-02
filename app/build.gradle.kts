plugins {
    alias(libs.plugins.android.application)
}

android {
    // 1. Update this to your project's actual package name
    namespace = "projet.fst.ma.starsgallery"

    // 2. INCREASE THIS TO 36 (Recommended)
    compileSdk = 36

    defaultConfig {
        // 3. Update this to your project's actual package name
        applicationId = "projet.fst.ma.starsgallery"
        minSdk = 24

        // 4. INCREASE THIS TO 36 (To match compileSdk)
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)

    // Glide
    implementation("com.github.bumptech.glide:glide:4.15.1")
    annotationProcessor("com.github.bumptech.glide:compiler:4.15.1")

    // CircleImageView
    implementation("de.hdodenhof:circleimageview:3.1.0")

    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}