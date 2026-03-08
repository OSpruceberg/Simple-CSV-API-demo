package com.example.api_demo.rest;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api_demo.domain.DataRecord;
import com.example.api_demo.exception.InvalidLimitException;
import com.example.api_demo.service.DataService;


/**
 * REST controller that exposes the API endpoint for retrieving {@link DataRecord} data.
 * Handles incoming HTTP requests, validates request parameters, and delegates
 * data retrieval to the service layer.
 */
@RestController
public class DataController {

    private final DataService dataService;

    public DataController(DataService newDataService) {
        this.dataService = newDataService;
    }

    @GetMapping("/api/data")
    public ResponseEntity<List<DataRecord>> getData(@RequestParam(required = false) Integer limit) {

        List<DataRecord> data;

        if (limit == null) 
        {
            data = dataService.getAllData();
        } 
        
        else 
        {
            if (limit <= 0) 
            {
                throw new InvalidLimitException("limit must be a positive integer");
            }
            
            data = dataService.getLimitedData(limit);
        }

        if (data.isEmpty()) 
        {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(data);
    }
}