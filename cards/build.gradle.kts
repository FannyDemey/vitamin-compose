import com.decathlon.vitamin.compose.Dependencies

plugins {
    id("com.android.library")
    id("kotlin-android")
    id("VitaminComposeLibraryPlugin")
    id("com.vanniktech.maven.publish")
    id("shot")
}

dependencies {
    api(project(":foundation"))
    api(project(":buttons"))
    implementation(Dependencies.Compose.tooling)
    implementation(Dependencies.Test.testRules)
    debugImplementation(Dependencies.Compose.coil)
    debugApi(project(":tags"))
    androidTestImplementation(Dependencies.Compose.test)
    debugImplementation(Dependencies.Compose.testManifest)
}
