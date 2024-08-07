package com.linkedin.app;

public class TimeConsumingTask {

  public void performTask() {
    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
