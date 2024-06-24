package com.pmd.notification.factory;

public class EmailNotification implements Notification {
  @Override
  public void notifyUser(String message) {
    System.out.println("Sending an Email notification: " + message);
    // Logic to send email
  }
}