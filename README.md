# Quarkus - JDK specifics testsuite
Testsuite for Quarkus applications with features introduced in new JDK releases

Per discussion on https://github.com/quarkusio/quarkus/issues/8802 `MAVEN_OPTS="--enable-preview"` needs to be used to ensure correct propagation to all maven plugins.

## Execution
Profiles get activated based on used JDK version 
```
MAVEN_OPTS="--enable-preview" mvn clean verify
```

## Dev mode
```
MAVEN_OPTS="--enable-preview" mvn quarkus:dev -pl quarkus-jdk15
```