package com.scaler.firstjavaproject.firstjavaproject.Advice;

import com.scaler.firstjavaproject.firstjavaproject.DTO.ErrorDTO;
import com.scaler.firstjavaproject.firstjavaproject.Exception.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorDTO> CategoryNotFound(CategoryNotFoundException exception) {
        ErrorDTO dto = new ErrorDTO();
        dto.setCode("203_status_code");
        dto.setMessage(exception.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.NOT_FOUND);
    }
}
