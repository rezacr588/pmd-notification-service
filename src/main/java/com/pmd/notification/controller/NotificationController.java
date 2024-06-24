package com.pmd.notification.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pmd.notification.service.WebSocketNotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

  @Autowired
  private WebSocketNotificationService webSocketNotificationService;

  @PostMapping
  public void sendNotification(@RequestBody NotificationRequest request) {
    webSocketNotificationService.sendNotification(request.getType(), request.getMessage());
  }

  public static class NotificationRequest {
    private String type;
    private String message;

    // Getters and Setters
    public String getType() {
      return type;
    }

    public void setType(String type) {
      this.type = type;
    }

    public String getMessage() {
      return message;
    }

    public void setMessage(String message) {
      this.message = message;
    }
  }
}