package com.shinesolutions.swagger.service;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EndpointService<T> {
    public ResponseEntity<List<T>> getResponseEntity() throws Exception;
    public String getResponseHeader();
    public int getResponseStatus();
    public String getResponseContent();
}
