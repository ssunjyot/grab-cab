# grab-cab
A simple cab booking micro-service

## Problem Statement

Write an API that provides a REST interface for the following business
requirements:

1. A user should be able to request a booking for a cab from pickup location
A to pickup location B
2. A user should be able to view his past bookings
3. A user should be able to get cabs that are nearby.

These requirements are a subset of the needs of a cab booking platform like
Uber/Ola.

## Prerequisites

GrabCab is a Java 11 Maven project. Having `Maven` & `Java 11` installed and on $PATH is a must.

It has been built using Spring Boot and interfaces with the user over Rest API. I suggest installing `Postman` to make REST calls.

## Run Instructions

To compile the project, run the following command :

`mvn clean install`

This command will build the project and also run all tests.

After building the jar navigate to the target directory, you can start the application using :

`java -jar grab-cab-0.0.1-SNAPSHOT.jar`

***The application starts Tomcat on port `4444` by default. This is configurable via `application.properties` file.***

Once the application is started, you can use `Postman` or run the following cURL requests to start booking Cabs!

## Exploring the API

Swagger has been used to define the API. It allows for route exploration and testing.

Once the application is run, it can be found at the following address :
[http://localhost:4444/swagger-ui.html](http://localhost:4444/swagger-ui.html)

Database console can be accessed at :
http://localhost:4444/h2

## Designing the solution

Based on the problem statement, I decided to use H2 as the in-memory SQL database and Hibernate as the ORM.

After I decided the technologies, I started implementing my Application using principles of **Domain Driven Design** and OOP.

I planned on creating a REST API using Spring Boot which gives most of the boiler plate code and set up required. For Unit testing I decided to use JUnit.

For validating REST calls and returning relevant HTTP response codes, I used the inbuilt Spring framework Validation API.
The application prioritizes the usage of framework or library over reinventing the wheel.

## Future enhancements

1. This solution can be extended to build a complex Cab Booking platform with real world Positional information (Instead of using basic 2-D positions)
2. The Cab allotment logic can be modified to take more real parameters into consideration like Traffic, Congestion and Profitability.
3. A more scalable, better suited database(according to the data model) can be chosen to handle more load.
