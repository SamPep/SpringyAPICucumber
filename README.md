# SpringyAPICucumber
A Java Spring API with Cucumber BDD testing.

## Prerequisites

* JDK 1.8 or later
* Gradle 4 or later
* Lombok
* Cucumber

## Start Up

To build the application:

```
./gradlew build
```

To run the JUnit tests:

```
./gradlew test
```

To run the Cucumber tests:

```
./gradlew cucumber
```

To run the application:

```
java -jar build/libs/springy-api-0.0.1-SNAPSHOT.jar
```

## Usage

To retrieve all users, hit the following route:

```
localhost:8080/users
```

To retrieve all users listed as living in London, hit the following route:

```
localhost:8080/users/london
```

To retrieve all users whose current coordinates are within 50 miles of London, hit the following route:

```
localhost:8080/users/london-radius
```