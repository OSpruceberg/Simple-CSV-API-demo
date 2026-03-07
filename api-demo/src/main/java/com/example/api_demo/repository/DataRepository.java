package com.example.api_demo.repository;

import java.util.List;
import com.example.api_demo.domain.*;

/**
 * Repository interface defines the common functionality for repositories for use in this project. The repository are 
 * responsible for retrieving data records from the underlying data source.
 *
 * Implementations handle access to the data storage (e.g., CSV file)
 * and return domain objects representing the stored records.
 */
public interface DataRepository {

    public List<DataRecord> findDataWithLimit(int limit);

}
