package com.pmd.notification.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.pmd.notification.entity.NotificationEntity;
import com.pmd.notification.factory.Notification;
import com.pmd.notification.factory.NotificationFactory;
import com.pmd.notification.handler.NotificationWebSocketHandler;
import com.pmd.notification.repository.NotificationRepository;

@Service
public class NotificationService {

  @Autowired
  private NotificationRepository notificationRepository;

  private final NotificationFactory notificationFactory = new NotificationFactory();

  public void sendNotification(String type, String message) {
    Notification notification = notificationFactory.createNotification(type);
    if (notification != null) {
      notification.notifyUser(message);

      // Save notification to the database
      NotificationEntity notificationEntity = new NotificationEntity(type, message);
      notificationRepository.save(notificationEntity);

      // Send notification via WebSocket
      List<WebSocketSession> sessions = NotificationWebSocketHandler.getSessions();
      TextMessage textMessage = new TextMessage(message);
      for (WebSocketSession session : sessions) {
        if (session.isOpen()) {
          try {
            session.sendMessage(textMessage);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    }
  }
}