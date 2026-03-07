package com.example.api_demo.rest;

import org.springframework.web.bind.annotation.RestController;

import com.example.api_demo.domain.DataRecord;
import com.example.api_demo.service.*;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DataController {

    private DataService service;

    public DataController(DataService newService){
        this.service = newService;
    }

    @RequestMapping("/api/data")
    public List<DataRecord> getData(@RequestParam int limit) {
        return service.getData(limit);
    }
    
}
