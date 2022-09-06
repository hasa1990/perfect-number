# Perfect Number App
Spring boot application with perfect number related services

#### Pre-requisits
1. JDK 1.8 or later
2. Gradle 4+

#### Build the application
Execute below command

	./gradlew clean build

#### Run the application
Execute below command

	./gradlew bootRun

### Configurations
- Base context path is /com/worldline/api

## API Information

### Perfect Number Validation Service
This service validates if the given number satisfies perfect number rules

#### URI
GET /com/worldline/api/perfect-number/{number}
- ex:

	http://localhost:8080/com/worldline/api/perfect-number/6

#### Response
true/false

### Perfect Numbers Within a given range
This service provides a list of perfect numbers within start (inclusive) and end (exclusive)

#### URI
GET /com/worldline/api/perfect-numbers?start={start}&end={end}
- ex:

	http://localhost:8080/com/worldline/api/perfect-numbers?start=1&end=100

#### Response
Array of perfect numbers
- ex:
	[
    		6,
    		28
	]

