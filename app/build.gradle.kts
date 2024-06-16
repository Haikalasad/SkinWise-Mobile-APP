plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("kotlin-parcelize")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.skinwise"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.skinwise"
        minSdk = 29
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"


        //Artikel
        buildConfigField("String", "API_KEY", "\"08791ed361504d93aec152aabfdd0627\"")
        buildConfigField("String", "BASE_URL_ARTICLE", "\"https://newsapi.org/\"")

        buildConfigField("String","SERVER_KEY","\"AIzaSyA11Y_Nh2hOhkw13INjetr82P-JXq9A7kY\"")
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
        mlModelBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation ("androidx.viewpager2:viewpager2:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("com.google.firebase:firebase-firestore:25.0.0")
    implementation("com.google.firebase:firebase-messaging:24.0.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")


    implementation("androidx.datastore:datastore-preferences:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.activity:activity-ktx:1.7.2")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.11.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation ("com.github.bumptech.glide:glide:4.12.0")

    //jwt library
    implementation ("io.jsonwebtoken:jjwt-api:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-impl:0.11.2")
    implementation ("io.jsonwebtoken:jjwt-jackson:0.11.2")

    //splash library
    implementation ("androidx.core:core-splashscreen:1.0.1")
    implementation ("de.hdodenhof:circleimageview:3.1.0")

    //room database
    ksp("androidx.room:room-compiler:2.5.2")
    implementation("androidx.room:room-runtime:2.5.2")


    // maps library
    implementation("com.google.android.gms:play-services-maps:18.0.0")
    implementation("com.google.android.gms:play-services-location:18.0.0")


    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))

    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-firestore")
    implementation ("com.firebaseui:firebase-ui-firestore:8.0.0")
    implementation ("com.google.firebase:firebase-messaging:23.0.5")
    implementation ("com.android.volley:volley:1.2.0")


    implementation("io.coil-kt:coil:2.6.0")
    implementation("com.github.bumptech.glide:glide:4.16.0")

    implementation("org.tensorflow:tensorflow-lite-support:0.4.4")
    implementation("org.tensorflow:tensorflow-lite-metadata:0.4.4")
    implementation("org.tensorflow:tensorflow-lite-task-vision:0.4.4")
    implementation("org.tensorflow:tensorflow-lite-gpu:2.3.0")

    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")

    implementation ("androidx.fragment:fragment-ktx:1.3.6")
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")


    implementation ("androidx.appcompat:appcompat:1.3.1")

    val cameraxVersion = "1.2.2"

    implementation("androidx.camera:camera-camera2:$cameraxVersion")
    implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
    implementation("androidx.camera:camera-view:$cameraxVersion")
    implementation ("androidx.camera:camera-extensions:$cameraxVersion")

    implementation("androidx.exifinterface:exifinterface:1.3.6")
    implementation ("com.google.guava:guava:31.0.1-android")


}