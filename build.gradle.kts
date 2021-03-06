import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val kotlinVersion = "1.1.3-2"
    extra["kotlinVersion"] = kotlinVersion

    repositories {
        mavenCentral()
    }
    dependencies {
        classpath(kotlinModule("gradle-plugin", kotlinVersion))
    }
}

apply {
    plugin("kotlin")
}

repositories {
    mavenCentral()
    maven {
        setUrl("https://repo.spring.io/milestone")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

val kotlinVersion = extra["kotlinVersion"] as String

dependencies {
    compile(kotlinModule("stdlib-jre8", kotlinVersion))
    compile("io.projectreactor:reactor-core:3.1.0.M3")
    compile("io.reactivex.rxjava2:rxjava:2.0.5")
    testCompile("junit:junit:4.12")
    testCompile("io.projectreactor:reactor-test:3.1.0.M3") {
        exclude("io.projectreactor", "reactor-core")
    }
}
