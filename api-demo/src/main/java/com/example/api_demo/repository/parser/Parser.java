package com.example.api_demo.repository.parser;

import com.example.api_demo.domain.DataRecord;

/*
* This interface defines the required common functionality of a parser used in this project.
*
*/
public interface Parser {

    DataRecord parseLine(String line);
}
