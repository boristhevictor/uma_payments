package com.borysp.payments.uma.app.controller.employee.error;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class EmployeeControllerErrorAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ShortErrorResponse> notFound(Exception e, WebRequest request) {
        return new ResponseEntity<>(
                new ShortErrorResponse()
                .setMsg(e.getMessage())
                .setStatus(HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @Getter
    @Setter
    @Accessors(chain = true)
    class ShortErrorResponse {
        LocalDateTime timeWhenOccurred = LocalDateTime.now();
        int status;
        String msg;
    }
}
