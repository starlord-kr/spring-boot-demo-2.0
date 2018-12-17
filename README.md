# Spring Boot 2.0 Demo

## How to deploy with environment.

##### Using Gradle
###### 1. gradle clean build
###### 2. java -jar -Dspring.profiles.active={env} build/libs/{SNAPSHOP}.jar | java -jar build/libs/{SNAPSHOP}.jar --spring.profiles.active={env}
###### - env : local | dev | production

