# Simple-CSV-API-demo

A simple REST API built with **Java and Spring Boot** that reads records from a CSV file and returns them as JSON.

The API supports retrieving all records or limiting the number of returned records via a query parameter.

# Tech Stack

* Java 25
* Spring Boot
* Maven
* Embedded Tomcat


# Project Structure


src/main/java/com/example/api_demo

rest/            → REST controllers
service/         → Application logic
repository/      → Data access
repository/parser → CSV parsing
domain/          → Domain objects
exception/       → Custom exceptions and error handling

# Building the Application

Open a terminal in the project root and run:

mvn clean install

This command will:

* download dependencies
* compile the project
* package the application


# Running the Application

Start the application with:


mvn spring-boot:run


When the application starts you should see:


Tomcat started on port 8080


The API is now available locally.


# API Endpoint

## Get all records


GET /api/data


Example:


http://localhost:8080/api/data


Returns all records from the CSV file.


## Get limited number of records


GET /api/data?limit=3


Example:


http://localhost:8080/api/data?limit=3


Returns the first **3 records** from the CSV file.


# Example Response

Example JSON response:

[
  {
    "id": 1,
    "name": "Alice",
    "age": 28,
    "email": "alice@example.com"
  },
  {
    "id": 2,
    "name": "Bea",
    "age": 12,
    "email": "bea@example.com"
  }
]



# CSV Data Source

The application reads data from the file:


src/main/resources/data.csv



# CSV Format

Each row must follow this structure:


id;name;age;email


Example:


1;Alice;28;alice@example.com
2;Bea;12;bea@example.com
3;Ceasar;56;ceasar@example.com
4;David;3;david@example.com


# Error Handling

The API returns appropriate HTTP responses for common errors.

| Scenario               | Response                  |
| ---------------------- | ------------------------- |
| invalid limit value    | 400 Bad Request           |
| invalid parameter type | 400 Bad Request           |
| empty CSV file         | 204 No Content            |
| CSV read error         | 500 Internal Server Error |


# Example Requests

Return all data:


http://localhost:8080/api/data


Return limited data:


http://localhost:8080/api/data?limit=2


Invalid request:


http://localhost:8080/api/data?limit=abc


# Running on Windows (Quick Guide)

1. Install **Java 21**
2. Install **Maven**
3. Open **PowerShell**
4. Navigate to the project folder
5. Run:


mvn spring-boot:run


Then open:

http://localhost:8080/api/data