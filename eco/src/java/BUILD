licenses(["notice"])

package(default_visibility = ["//visibility:public"])

eco_deps = [
    "@commons_cli_commons_cli//jar",
    "@org_yaml_snakeyaml//jar",
    "//third_party/java:logging",
    "//storm-compatibility/src/java:storm-compatibility-java-neverlink",
    "//heron/api/src/java:api-java-low-level",
    "//heron/common/src/java:basics-java",
]

java_library(
    name = "eco-defs-java",
    srcs = glob(["com/twitter/heron/eco/definition/*.java"]),
    deps = eco_deps,
)

java_library(
    name = "eco-parser-java",
    srcs = glob(["com/twitter/heron/eco/parser/*.java"]),
    deps = eco_deps + [":eco-defs-java"],
)

java_library(
    name = "eco-builder-java",
    srcs = glob(["com/twitter/heron/eco/builder/*.java"]),
    deps = eco_deps + [":eco-defs-java"],
)

java_library(
    name = "eco-storm-builder-java",
    srcs = glob(["com/twitter/heron/eco/builder/storm/*.java"]),
    deps = eco_deps + [
        ":eco-builder-java",
        ":eco-defs-java",
    ],
)

java_library(
    name = "eco-heron-builder-java",
    srcs = glob(["com/twitter/heron/eco/builder/heron/*.java"]),
    deps = eco_deps + [
        ":eco-builder-java",
        ":eco-defs-java",
    ],
)

java_library(
    name = "eco-submit-java",
    srcs = glob(["com/twitter/heron/eco/submit/*.java"]),
    deps = eco_deps, 
)

java_library(
    name = "eco-java",
    srcs = glob(["com/twitter/heron/eco/*.java"]),
    deps = eco_deps + [
        ":eco-defs-java",
        ":eco-parser-java",
        ":eco-builder-java",
        ":eco-heron-builder-java",
        ":eco-storm-builder-java",
        ":eco-submit-java",
    ],
)
