package com.shinesolutions.swagger.service;

import com.shinesolutions.swagger.model.CarShow;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IEndpointService<T> {
    public boolean doGet()throws Exception;
    public String getResponseHeader();
    public int getResponseStatus();
    public String getResponseContent();
    public ResponseEntity<List<T>> getEntity();
}
