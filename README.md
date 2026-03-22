# Order Management App

A Spring Boot application for managing orders, built as a take-home assessment for Crio.

## Features
- Create, update, and delete orders
- RESTful API endpoints
- Layered architecture (Controller, Service, Repository)
- Configurable via `application.properties`
- Unit and integration tests

## Project Structure
```
order-management-app/
├── src/
│   ├── main/
│   │   ├── java/com/crio/order_management_app/
│   │   │   ├── OrderManagementApplication.java
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   └── repository/
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
│   └── test/
│       └── java/com/crio/order_management_app/
│           └── OrderManagementAppApplicationTests.java
├── build.gradle
├── settings.gradle
└── gradlew, gradlew.bat
```

## Getting Started

### Prerequisites
- Java 17 or above
- Gradle (or use the included wrapper)

### Build and Run

```
./gradlew build
./gradlew bootRun
```

The application will start on [http://localhost:8080](http://localhost:8080).

### Running Tests

```
./gradlew test
```

## Configuration
Edit `src/main/resources/application.properties` to configure database and other settings.

## License
This project is for assessment purposes only.
