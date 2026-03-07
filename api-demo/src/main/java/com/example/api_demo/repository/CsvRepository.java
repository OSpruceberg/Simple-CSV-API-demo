package com.example.api_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.example.api_demo.repository.parser.Parser;
import com.example.api_demo.domain.DataRecord;
import com.example.api_demo.exception.CsvReadException;

/**
 * Repository implementation that reads {@link DataRecord} objects from a CSV file.
 * Uses a {@link Parser} to convert each CSV row into a domain object.
 */
@Repository
public class CsvRepository implements DataRepository {

    private final Parser csvParser;

    public CsvRepository(Parser newParser) {
        this.csvParser = newParser;
    }

    @Override
    public List<DataRecord> getLimitedData(int limit) {

        List<DataRecord> dataRows = new ArrayList<>();
        ClassPathResource dataSource = new ClassPathResource("data.csv");

        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataSource.getInputStream()));

            String line;
            int index = 0;

            while ((line = bufferReader.readLine()) != null && index < limit) {
                dataRows.add(csvParser.parseLine(line));
                index++;
            }

            return dataRows;

        } catch (Exception e) {
            throw new CsvReadException("Problem reading CSV file", e);
        }
    }

    @Override
    public List<DataRecord> getAllData() {

        List<DataRecord> dataRows = new ArrayList<>();
        ClassPathResource dataSource = new ClassPathResource("data.csv");

        try {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataSource.getInputStream()));

            String line;

            while ((line = bufferReader.readLine()) != null) {
                dataRows.add(csvParser.parseLine(line));
            }

            return dataRows;

        } catch (Exception e) {
            throw new CsvReadException("Problem reading CSV file", e);
        }
    }
}