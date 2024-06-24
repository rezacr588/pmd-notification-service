package com.pmd.notification.factory;

public class NotificationFactory {
  public Notification createNotification(String type) {
    if (type == null || type.isEmpty()) {
      return null;
    }
    switch (type.toUpperCase()) {
      case "EMAIL":
        return new EmailNotification();
      case "SMS":
        return new SMSNotification();
      case "PUSH":
        return new PushNotification();
      default:
        return null;
    }
  }
}