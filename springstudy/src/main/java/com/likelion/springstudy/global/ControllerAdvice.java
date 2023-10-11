package com.likelion.springstudy.global;

import com.likelion.springstudy.global.exception.BusinessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<Void> handleEntityNotFoundException(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Void> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.badRequest().build();
    }

    // 커스텀 Exception
    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Void> handleBusinessException(BusinessException e) {
        return ResponseEntity.internalServerError().build();
    }
}
