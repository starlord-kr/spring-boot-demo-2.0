package com.slowstarter.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class ErrorResponse {
    private Error error;
}

@Data
@AllArgsConstructor
@Builder
class Error {
    private Integer code;
    private String message;
}