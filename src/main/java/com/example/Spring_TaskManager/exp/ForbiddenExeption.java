package com.example.Spring_TaskManager.exp;

public class ForbiddenExeption extends RuntimeException{
    public ForbiddenExeption(String message){
        super(message);
    }
}
