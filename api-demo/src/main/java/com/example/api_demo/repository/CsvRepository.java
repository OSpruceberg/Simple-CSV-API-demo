package com.example.api_demo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.example.api_demo.repository.parser.Parser;
import com.example.api_demo.domain.DataRecord;

@Repository
public class CsvRepository implements DataRepository {

    private final Parser csvParser;

    public CsvRepository(Parser newParser) {
        this.csvParser = newParser;
    }

    @Override
    public List<DataRecord> findDataWithLimit(int limit) {

        List<DataRecord> dataRows = new ArrayList<>();
        ClassPathResource dataSource = new ClassPathResource("data.csv");

        try
        {
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataSource.getInputStream()));

            String line;
            int index = 0;

            while ((line = bufferReader.readLine()) != null && index < limit) {
                dataRows.add(csvParser.parseLine(line));
                index++;
            }

            return dataRows;

        } catch (Exception e) {
            throw new RuntimeException("Problem reading CSV file", e);
        }
    }
}