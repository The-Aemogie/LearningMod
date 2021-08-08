import net.minecraftforge.gradle.userdev.UserDevExtension

val mappingsChannel: String by extra
val mappingsVersion: String by extra
val forgeVersion: String by extra

buildscript {
	repositories { maven("https://files.minecraftforge.net/maven") }
	dependencies { classpath("net.minecraftforge.gradle:ForgeGradle:+") }
}

plugins {
	java
	kotlin("jvm") version "1.5.21"
}

apply {
	plugin("net.minecraftforge.gradle")
}

version = "1.0"
group = "io.github.aemogie"

configure<UserDevExtension> {
	mappings(mappingsChannel, mappingsVersion)
	accessTransformer(File("src/main/resources/META-INF/accessTransformer.cfg"))
	runs {
		create("client") {
			workingDirectory(project.file(".run"))
			property("forge.logging.markers", "REGISTRIES")
			property("forge.logging.console.level", "debug")
			mods { sources.forEach { create("${project.name}-${it.name}") {source(it)} } }
		}
	}
}

dependencies {
	"minecraft"("net.minecraftforge:forge:$forgeVersion")
	implementation("io.github.spair:imgui-java-app:+")
	implementation(kotlin("stdlib-jdk8"))
}
tasks.withType<Jar> {
	manifest {
		attributes["Specification-Title"] = "Learning Mod"
		attributes["Specification-Vendor"] = "aemogie."
		attributes["Specification-Version"] = project.version
		attributes["Implementation-Title"] = project.name
		attributes["Implementation-Version"] = archiveVersion
		attributes["Implementation-Vendor"] = "aemogie."
	}
}