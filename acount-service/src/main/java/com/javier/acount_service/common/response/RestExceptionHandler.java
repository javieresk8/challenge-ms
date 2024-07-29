package com.javier.acount_service.common.response;

import com.javier.acount_service.domain.exceptions.NotEnoughSaldoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = NotEnoughSaldoException.class)
    public ResponseEntity handleNoEnoughSaldoException() {
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .message("La cuenta no tiene saldo suficiente")
                .code(HttpStatus.BAD_REQUEST.value())
                .build();
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ResponseEntity handleRuntimeException() {
        ExceptionModel exceptionModel = ExceptionModel.builder()
                .message("Service error, check the logs")
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
        return new ResponseEntity<ExceptionModel>(exceptionModel, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
