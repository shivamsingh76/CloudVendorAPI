package com.shivamsingh.restdemo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    
    public static ResponseEntity<Object> handleResponse 
            (Object data, String message, HttpStatus httpStatus) {

        Map<String, Object> response = new HashMap<>();
        response.put("data", data);
        response.put("message", message);
        response.put("httpStatus", httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
