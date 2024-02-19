rootProject.name = "java-spring-workspace"

include("module-java")

include("module-java:java-101")
findProject(":module-java:java-101")?.name = "java-101"
include("module-java:java-101:annotation")
findProject(":module-java:java-101:annotation")?.name = "annotation"
include("module-java:java-101:builder")
findProject(":module-java:java-101:builder")?.name = "builder"
include("module-java:java-101:record")
findProject(":module-java:java-101:record")?.name = "record"
include("module-java:java-101:version")
findProject(":module-java:java-101:version")?.name = "version"
include("module-java:java-101:jvm")
findProject(":module-java:java-101:jvm")?.name = "jvm"
include("module-java:java-101:bytecode")
findProject(":module-java:java-101:bytecode")?.name = "bytecode"
include("module-java:java-101:bytecode:agent")
findProject(":module-java:java-101:bytecode:agent")?.name = "agent"
include("module-java:java-101:reflection")
findProject(":module-java:java-101:reflection")?.name = "reflection"
include("module-java:java-101:reflection:custom-di")
findProject(":module-java:java-101:reflection:custom-di")?.name = "custom-di"
include("module-java:java-101:util-collections")
findProject(":module-java:java-101:util-collections")?.name = "util-collections"
include("module-java:java-101:lock")
findProject(":module-java:java-101:lock")?.name = "lock"
include("module-java:java-101:util-function")
findProject(":module-java:java-101:util-function")?.name = "util-function"
include("module-java:java-101:future")
findProject(":module-java:java-101:future")?.name = "future"
include("module-java:java-101:io")
findProject(":module-java:java-101:io")?.name = "io"
include("module-java:effective-java-3-E")
findProject(":module-java:effective-java-3-E")?.name = "effective-java-3-E"
include("module-java:java-labs")
findProject(":module-java:java-labs")?.name = "java-labs"
include("module-java:java-labs:flake")
findProject(":module-java:java-labs:flake")?.name = "flake"


include("module-spring")
include("module-spring:spring-lab:coupon-issuance-with-redis")
findProject(":module-spring:spring-lab:coupon-issuance-with-redis")?.name = "coupon-issuance-with-redis"
include("module-spring:spring-lab:restdocs-with-openapi")
findProject(":module-spring:spring-lab:restdocs-with-openapi")?.name = "restdocs-with-openapi"
include("module-spring:spring-101")
findProject(":module-spring:spring-101")?.name = "spring-101"
include("module-spring:spring-101:ioc-di")
findProject(":module-spring:spring-101:ioc-di")?.name = "ioc-di"
include("module-spring:spring-101:tomcat")
findProject(":module-spring:spring-101:tomcat")?.name = "tomcat"
include("module-spring:spring-101:transcation")
findProject(":module-spring:spring-101:transcation")?.name = "transcation"
include("module-spring:spring-lab:video-analysis-request")
findProject(":module-spring:spring-lab:video-analysis-request")?.name = "video-analysis-request"
include("module-spring:spring-lab")
findProject(":module-spring:spring-lab")?.name = "spring-lab"
include("module-spring:spring-101:test")
findProject(":module-spring:spring-101:test")?.name = "test"
include("module-java:java-101:virtual-thread")
findProject(":module-java:java-101:virtual-thread")?.name = "virtual-thread"
include("module-spring:spring-data-jpa")
findProject(":module-spring:spring-data-jpa")?.name = "spring-data-jpa"
