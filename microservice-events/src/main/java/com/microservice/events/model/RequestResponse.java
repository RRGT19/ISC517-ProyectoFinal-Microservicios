package com.microservice.events.model;

import java.io.Serializable;

public class RequestResponse implements Serializable {
  private boolean result;

  public RequestResponse(boolean result) {
    this.result = result;
  }

  public boolean isResult() {
    return result;
  }

  public void setResult(boolean result) {
    this.result = result;
  }
}
