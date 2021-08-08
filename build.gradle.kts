import net.minecraftforge.gradle.common.util.ModConfig
import net.minecraftforge.gradle.userdev.UserDevExtension
import net.minecraftforge.gradle.userdev.DependencyManagementExtension

val mappingsChannel: String by extra
val mappingsVersion: String by extra
val forgeVersion: String by extra

buildscript {
	repositories { maven("https://files.minecraftforge.net/maven") }
	dependencies { classpath("net.minecraftforge.gradle:ForgeGradle:+") }
}

plugins {
	idea
	java
	kotlin("jvm") version "1.5.21"
}

apply {
	plugin("net.minecraftforge.gradle")
}

version = "1.0"
group = "io.github.aemogie"

val libs = ArrayList<Dependency>()

configure<DependencyManagementExtension> {
	libs.add(deobf("software.bernie.geckolib:geckolib-forge-1.16.5:3.0.43"))
}

configure<UserDevExtension> {
	mappings(mappingsChannel, mappingsVersion)
	accessTransformer(File("src/main/resources/META-INF/accessTransformer.cfg"))
	runs {
		create("client") {
			workingDirectory(project.file(".run"))
			property("forge.logging.markers", "REGISTRIES")
			property("forge.logging.console.level", "debug")
			mods(closureOf<NamedDomainObjectContainer<ModConfig>> {
				create(project.name) {
					source(sourceSets["main"])
				}
			})
		}
	}
}
repositories { maven("https://dl.cloudsmith.io/public/geckolib3/geckolib/maven/") }

dependencies {
	minecraft("net.minecraftforge:forge:$forgeVersion")
	implementation("io.github.spair:imgui-java-app:+")
	implementation(kotlin("stdlib-jdk8"))
	libs.forEach{implementation(it)}
}
tasks.withType<Jar> {
	manifest {
		attributes(
			"Specification-Title" to "Learning Mod",
			"Specification-Vendor" to "aemogie.",
			"Specification-Version" to project.version,
			"Implementation-Title" to project.name,
			"Implementation-Version" to archiveVersion,
			"Implementation-Vendor" to "aemogie.",
		)
	}
	finalizedBy("reobfJar")
}

fun DependencyHandler.minecraft(
	dependencyNotation: Any
): Dependency? = add("minecraft", dependencyNotation)