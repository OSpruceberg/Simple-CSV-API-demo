package com.example.api_demo.domain;

/*
 * Represents a single record from the CSV data source.
 * Each instance corresponds to one row in the input file
 * and contains the parsed values for id, name, age, and email.
*/
public record DataRecord(long id, String name, int age, String email) {

}
