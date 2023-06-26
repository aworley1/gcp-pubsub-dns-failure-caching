plugins {
    kotlin("jvm") version "1.8.22"
    application
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation(platform("com.google.cloud:libraries-bom:26.11.0")) //This version doesn't seem to cache failed DNS lookups
//    implementation(platform("com.google.cloud:libraries-bom:26.12.0")) //This version seems to cache failed DNS lookups
    implementation("com.google.cloud:google-cloud-pubsub")
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("test_dns.ApplicationKt")
}

repositories {
    mavenCentral()
}
