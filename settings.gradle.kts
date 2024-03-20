pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "TestTask"
include(":app")
include(":core")
include(":core:network")
include(":data")
include(":features")
include(":features:list")
include(":core:theme")
include(":features:deteils")
