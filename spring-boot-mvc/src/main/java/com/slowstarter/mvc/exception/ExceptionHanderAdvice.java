package com.slowstarter.mvc.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHanderAdvice {


    private static Logger LOG = LoggerFactory.getLogger(ExceptionHanderAdvice.class);

    @ExceptionHandler(value = {InvalidParameterException.class})
    protected ResponseEntity<ErrorResponse> handleException(InvalidParameterException ex) {

        ErrorResponse errorResponse =
                ErrorResponse
                        .builder()
                        .error(Error
                                .builder()
                                .code(HttpStatus.BAD_REQUEST.value())
                                .message(ex.getMessage())
                                .build()
                        )
                        .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {

        LOG.info("-- ExceptionHanderAdvice.handle(RuntimeException ex)");
        LOG.info("-- message={}", ex.getMessage());

        ErrorResponse errorResponse =
                ErrorResponse
                        .builder()
                        .error(Error
                                .builder()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message(ex.getMessage())
                                .build()
                        )
                        .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {

        LOG.info("-- ExceptionHanderAdvice.handle(Exception ex)");
        LOG.info("-- message={}", ex.getMessage());

        ErrorResponse errorResponse =
                ErrorResponse
                        .builder()
                        .error(Error
                                .builder()
                                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                                .message(ex.getMessage())
                                .build()
                        )
                        .build();

        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
