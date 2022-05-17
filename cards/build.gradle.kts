import com.decathlon.vitamin.compose.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("VitaminComposeLibraryPlugin")
    id("com.vanniktech.maven.publish")
}

dependencies {
    api(project(":foundation"))
    api(project(":buttons"))
    implementation(Dependencies.Compose.tooling)
    debugImplementation(Dependencies.Compose.coil)
    debugApi(project(":tags"))
}
