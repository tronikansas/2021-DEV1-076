# 2021-DEV1-076
A Kata exercise to show a tdd in Java

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 3.8.1](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.exercise.tdd.kata.game.TennisGameApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Using the Application through Postman

The URl to be used is http://localhost:8080/viewScore.

In the body, we need to send the Json like the example below:
  - [{"name":"Nadal","score":4},{"name":"Federer","score":4}]

Changing the values given on score field, we will see the score of the Tennis Game**
