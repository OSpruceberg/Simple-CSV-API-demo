package com.example.api_demo.repository.parser;

import javax.management.RuntimeErrorException;

import org.springframework.stereotype.Component;

import com.example.api_demo.domain.DataRecord;

/**
 * Parses CSV lines and converts them into {@link DataRecord} objects.
 * This implementation is responsible for interpreting the CSV format
 * and mapping each row to a domain object.
 */
@Component
public class CsvParser implements Parser {

    private final String SEPARATOR = ";";
    //private final int EXPECTED_NBR_OF_COLUMNS = 4;
    private String[] parts;

    @Override
    public DataRecord parseLine(String line) {

        parts = line.split(SEPARATOR, -1); //-1 because indexing.

        try {

            long id = Long.parseLong(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);
            String email = parts[3];

            return new DataRecord(id, name, age, email);
            
            
        } catch (Error e) {
            throw new RuntimeErrorException(e);
        }


    }

}
