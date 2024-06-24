package com.pmd.notification.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pmd.notification.controller.NotificationRequest;

@FeignClient(name = "notification-service", url = "http://localhost:8080")
public interface NotificationClient {

  @PostMapping("/api/notifications")
  void sendNotification(@RequestBody NotificationRequest request);
}