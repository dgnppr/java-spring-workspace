rootProject.name = "java-spring-workspace"
include("module-java")
include("module-java:annotation")
findProject(":module-java:annotation")?.name = "annotation"
include("module-java:builder")
findProject(":module-java:builder")?.name = "builder"
include("module-java:record")
findProject(":module-java:record")?.name = "record"
include("module-java:version")
findProject(":module-java:version")?.name = "version"
include("module-java:jvm")
findProject(":module-java:jvm")?.name = "jvm"
include("module-java:bytecode")
findProject(":module-java:bytecode")?.name = "bytecode"
include("module-java:bytecode:agent")
findProject(":module-java:bytecode:agent")?.name = "agent"
include("module-java:reflection")
findProject(":module-java:reflection")?.name = "reflection"
include("module-java:reflection:custom-di")
findProject(":module-java:reflection:custom-di")?.name = "custom-di"
include("module-java:util-collections")
findProject(":module-java:util-collections")?.name = "util-collections"
include("module-java:lock")
findProject(":module-java:lock")?.name = "lock"

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
include("module-java:effective-java-3-E")
findProject(":module-java:effective-java-3-E")?.name = "effective-java-3-E"
include("module-java:util-function")
findProject(":module-java:util-function")?.name = "util-function"
include("module-java:jwt")
findProject(":module-java:jwt")?.name = "jwt"
include("module-spring:spring-lab:video-analysis-request")
findProject(":module-spring:spring-lab:video-analysis-request")?.name = "video-analysis-request"

include("module-spring:spring-lab")
findProject(":module-spring:spring-lab")?.name = "spring-lab"
