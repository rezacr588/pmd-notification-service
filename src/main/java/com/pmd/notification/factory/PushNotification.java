package com.pmd.notification.factory;

public class PushNotification implements Notification {
  @Override
  public void notifyUser(String message) {
    System.out.println("Sending a Push notification: " + message);
    // Logic to send push notification
  }
}