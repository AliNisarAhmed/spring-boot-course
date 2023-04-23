package com.ali.restdemo.rest;

public class StudentErrorResponse {
  private int status;
  private String message;
  private long timeStamp;

  public StudentErrorResponse() {

  }

  public StudentErrorResponse(int status, String message, long timeStamp) {
    this.status = status;
    this.message = message;
    this.timeStamp = timeStamp;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return this.message;
  }

  public void setMessage(String msg) {
    this.message = msg;
  }

  public long getTimeStamp() {
    return this.timeStamp;
  }

  public void setTimeStamp(long ts) {
    this.timeStamp = ts;
  }
}
