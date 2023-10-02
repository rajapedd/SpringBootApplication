package com.raja.DemoApplication.error;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException (String message){
        super(message);
    }
}
