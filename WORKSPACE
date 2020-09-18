workspace(name = "template_api")

load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_archive")
load("@bazel_tools//tools/build_defs/repo:http.bzl", "http_jar")

KOTLIN_VERSION = "1.3.70"
KOTLINX_COROUTINE_VERSION = "1.3.5"
KOTLINX_COROUTINE_IO_VERSION = "0.24.0"
KOTLINX_SERIALIZATION_RUNTIME = "0.14.0"
KOTLINX_IO_VERSION = "0.1.15"

DAGGER_VERSION = "2.21"
JAVAX_INJECT_VERSION = "1"
JUNIT4_VERSION = "4.12"
JUNIT_VERSION = "5.6.0"
JUNIT_PLATFORM_VERSION = "1.6.0"
KTOR_VERSION = "1.3.0"
SJF4J_VERSION = "1.8.0-alpha0"
JACKSON_VERSION = "2.10.3"
MONGODB_VERSION = "3.12.0"
KOIN_VERSION = "2.1.5"
KOIN_KTOR_VERSION = "0.9.3"
LOGBACK_VERSION = "1.2.3"
MOCKK_VERSION = "1.9.3"
KONFIG_VERSION = "1.6.10.0"
KMONGO_VERSION = "3.12.0"
OKHTTP_VERSION = "4.4.0"
STRIPE_VERSION = "18.5.0"
EXPOSED_VERSION = "0.24.1"
AWS_VERSION = "1.11.775"

# -- KOTLIN --

rules_kotlin_version = "legacy-1.3.0-rc4"
rules_kotlin_sha = "fe32ced5273bcc2f9e41cea65a28a9184a77f3bc30fea8a5c47b3d3bfc801dff"
http_archive(
    name = "io_bazel_rules_kotlin",
    urls = ["https://github.com/bazelbuild/rules_kotlin/archive/%s.zip" % rules_kotlin_version],
    type = "zip",
    strip_prefix = "rules_kotlin-%s" % rules_kotlin_version,
    sha256 = rules_kotlin_sha,
)

load("@io_bazel_rules_kotlin//kotlin:kotlin.bzl", "kotlin_repositories", "kt_register_toolchains")

KOTLINC_RELEASE_SHA = "709d782ff707a633278bac4c63bab3026b768e717f8aaf62de1036c994bc89c7"

KOTLINC_RELEASE = {
    "urls": [
        "https://github.com/JetBrains/kotlin/releases/download/v{v}/kotlin-compiler-{v}.zip".format(v = KOTLIN_VERSION),
    ],
    "sha256": KOTLINC_RELEASE_SHA,
}

kotlin_repositories(compiler_release = KOTLINC_RELEASE)
register_toolchains("//:kotlin_toolchain")

# -- MAVEN --

RULES_JVM_EXTERNAL_TAG = "3.0"
RULES_JVM_EXTERNAL_SHA = "62133c125bf4109dfd9d2af64830208356ce4ef8b165a6ef15bbff7460b35c3a"

http_archive(
    name = "rules_jvm_external",
    strip_prefix = "rules_jvm_external-%s" % RULES_JVM_EXTERNAL_TAG,
    sha256 = RULES_JVM_EXTERNAL_SHA,
    url = "https://github.com/bazelbuild/rules_jvm_external/archive/%s.zip" % RULES_JVM_EXTERNAL_TAG,
)

load("@rules_jvm_external//:defs.bzl", "maven_install")

maven_install(
    name = "maven",
    artifacts = [
        # kotlin
        "org.jetbrains.kotlin:kotlin-stdlib:%s" % KOTLIN_VERSION,
        "org.jetbrains.kotlin:kotlin-reflect:%s" % KOTLIN_VERSION,
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:%s" % KOTLINX_COROUTINE_VERSION,
        "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:%s" % KOTLINX_COROUTINE_VERSION,
        "org.jetbrains.kotlinx:kotlinx-coroutines-io:%s" % KOTLINX_COROUTINE_IO_VERSION,
        "org.jetbrains.kotlinx:kotlinx-io:%s" % KOTLINX_IO_VERSION,
        "org.jetbrains.kotlin:kotlin-maven-plugin:%s" % KOTLIN_VERSION,

        # guava
        "com.google.guava:guava:28.2-jre",

        # jackson
        "com.fasterxml.jackson.core:jackson-core:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.core:jackson-annotations:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.core:jackson-databind:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.datatype:jackson-datatype-guava:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.datatype:jackson-datatype-jsr310:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.module:jackson-modules-java8:%s" % JACKSON_VERSION,
        "com.fasterxml.jackson.module:jackson-module-kotlin:%s" % JACKSON_VERSION,

        "com.google.dagger:dagger:%s" % DAGGER_VERSION,
        "com.google.dagger:dagger-compiler:%s" % DAGGER_VERSION,
        "javax.inject:javax.inject:%s" % JAVAX_INJECT_VERSION,

         # logger
        "org.slf4j:slf4j-api:%s" % SJF4J_VERSION,
        "org.slf4j:slf4j-simple:%s" % SJF4J_VERSION,
        "ch.qos.logback:logback-classic:%s" %  LOGBACK_VERSION,

        # junit
        "junit:junit:%s" % JUNIT4_VERSION,
        "org.junit.jupiter:junit-jupiter-api:%s" % JUNIT_VERSION,
        "org.junit.jupiter:junit-jupiter-engine:%s" % JUNIT_VERSION,
        "org.junit.platform:junit-platform-launcher:%s" % JUNIT_PLATFORM_VERSION,
        "org.junit.platform:junit-platform-runner:%s" % JUNIT_PLATFORM_VERSION,
        "org.junit.platform:junit-platform-console:%s" % JUNIT_PLATFORM_VERSION,
        "org.jetbrains.kotlin:kotlin-test:%s" % KOTLIN_VERSION,

        # ktor (server)
        "io.ktor:ktor-server:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-netty:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-core:%s" % KTOR_VERSION,
        "io.ktor:ktor-server-host-common:%s" % KTOR_VERSION,

        "io.ktor:ktor-client:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-core:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-logging:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-json:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-gson:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-cio:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-serialization:%s" % KTOR_VERSION,
        "io.ktor:ktor-client-okhttp:%s" % KTOR_VERSION,

        "io.ktor:ktor-http:%s" % KTOR_VERSION,
        "io.ktor:ktor-http-cio:%s" % KTOR_VERSION,
        "io.ktor:ktor-http-cio-jvm:%s" % KTOR_VERSION,

        "io.ktor:ktor-jackson:%s" % KTOR_VERSION,
        "io.ktor:ktor-gson:%s" % KTOR_VERSION,
        "io.ktor:ktor-locations:%s" % KTOR_VERSION,
        "io.ktor:ktor-features:%s" % KTOR_VERSION,
        "io.ktor:ktor-utils:%s" % KTOR_VERSION,
        "io.ktor:ktor-network:%s" % KTOR_VERSION,
        "io.ktor:ktor-io:%s" % KTOR_VERSION,
        "io.ktor:ktor-websockets:%s" % KTOR_VERSION,

        "io.ktor:ktor-server-test-host:%s" % KTOR_VERSION,

        # koin (dependency injection)
        "org.koin:koin-core:%s" % KOIN_VERSION,
        "org.koin:koin-core-ext:%s" % KOIN_VERSION,
        "org.koin:koin-test:%s" % KOIN_VERSION,
        "org.koin:koin-ktor:%s" % KOIN_VERSION,
    ],
    repositories = [
        "https://repo1.maven.org/maven2/",
        "https://jcenter.bintray.com/",
        "https://mvnrepository.com/artifact/",
        "https://jitpack.io/"
    ],
    version_conflict_policy = "pinned",
    fetch_sources = True,
    strict_visibility = True,
    fail_on_missing_checksum = True,
    use_unsafe_shared_cache = False,
    generate_compat_repositories = True,
    maven_install_json = "//:maven_install.json",
)

load("@maven//:defs.bzl", "pinned_maven_install")
pinned_maven_install()

load("@maven//:compat.bzl", "compat_repositories")
compat_repositories()