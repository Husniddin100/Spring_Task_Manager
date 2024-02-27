package com.example.Spring_TaskManager.controller;

import com.example.Spring_TaskManager.exp.AppBadException;
import com.example.Spring_TaskManager.exp.ForbiddenExeption;
import com.example.Spring_TaskManager.exp.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@Slf4j
@ControllerAdvice
public class ExeptionHandlerController {
    @ExceptionHandler(AppBadException.class)
    private ResponseEntity<?> handle(AppBadException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
    @ExceptionHandler(ForbiddenExeption.class)
    private ResponseEntity<?> handle(ForbiddenExeption e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    @ExceptionHandler(JwtException.class)
    private ResponseEntity<?> handle(JwtException e) {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<?>handle(RuntimeException e) {
        log.error(e.getMessage());
        return ResponseEntity.internalServerError().body(e.getMessage());
    }
}