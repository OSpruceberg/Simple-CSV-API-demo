package com.example.api_demo.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.api_demo.domain.DataRecord;
import com.example.api_demo.repository.DataRepository;

/**
 * Service layer responsible for retrieving and processing {@link DataRecord}
 * objects.
 * Acts as an intermediary between the REST controller and the data repository,
 * applying business logic before returning results to the API layer.
 */
@Service
public class DataService {

    private DataRepository repo;

    public DataService(DataRepository newRepo) {

        this.repo = newRepo;
    }

    public List<DataRecord> getLimitedData(int limit) {

        return repo.getLimitedData(limit);
    }

    public List<DataRecord> getAllData() {

        return repo.getAllData();
    }

}
