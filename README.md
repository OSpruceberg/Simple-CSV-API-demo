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

# Building the Application (Windows)

A snapshot build is already provided in the target-folder but if you wish to build the project yourself you can do this by:

1. Clone the repository and navigate to the root.

2. Open a terminal in the project root and run: ".\mvnw.cmd clean package"

This command will:

* download dependencies
* compile the project
* package the application (.jar-format)


# Running the Application (Windows)

1. To run the application it is recommended to first download the ready-made snapshot build under the target folder. 

2. Navigate to the downloaded build file and open a terminal.

3. In the terminal, type "java -jar api-demo-0.0.1-SNAPSHOT.jar" to start the application

4. When the application starts you should see:

Tomcat started on port 8080

The API is now available locally and can be accesed by "http://localhost:8080/api/data".


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

The API should return an appropriate HTTP responses for common errors.

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