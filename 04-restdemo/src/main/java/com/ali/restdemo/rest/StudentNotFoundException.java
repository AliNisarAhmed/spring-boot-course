package com.ali.restdemo.rest;

public class StudentNotFoundException extends RuntimeException {
  public StudentNotFoundException(String msg) {
    super(msg);
  }

  public StudentNotFoundException(String msg, Throwable cause) {
    super(msg, cause);
  }

  public StudentNotFoundException(Throwable cause) {
    super(cause);
  }
}
