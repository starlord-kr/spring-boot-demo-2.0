package com.slowstarter.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.slowstarter")
public class ExceptionHanderAdvice extends ResponseEntityExceptionHandler {

    private static Logger LOG = LoggerFactory.getLogger(ExceptionHanderAdvice.class);

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

//
//    @ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class, MissingPathVariableException.class})
//    protected ResponseEntity<Object> handleException(
//            RuntimeException ex,
//            WebRequest request) {
//
//        ErrorResponse errorResponse =
//                ErrorResponse
//                        .builder()
//                        .error(Error
//                                .builder()
//                                .code(HttpStatus.BAD_REQUEST.value())
//                                .message(ex.getMessage())
//                                .build()
//                        )
//                        .build();
//
//        return handleMissingPathVariable(ex, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
//    }

//    @ExceptionHandler({IllegalArgumentException.class, RuntimeException.class})
//    protected ResponseEntity<ErrorResponse> handleException(RuntimeException ex) {
//
//        LOG.info("-- ExceptionHanderAdvice.handle(HellloWorldException ex)");
//        LOG.info("-- message={}", ex.getClass());
//        LOG.info("-- message={}", ex.getMessage());
//
//
//        ErrorResponse errorResponse =
//                ErrorResponse
//                        .builder()
//                        .error(Error
//                                .builder()
//                                .code(HttpStatus.BAD_REQUEST.value())
//                                .message(ex.getMessage())
//                                .build()
//                        )
//                        .build();
//
//        return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
//    }

    @ExceptionHandler(InvalidParameterException.class)
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


}
