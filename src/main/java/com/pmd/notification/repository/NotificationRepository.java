package com.pmd.notification.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pmd.notification.entity.NotificationEntity;

public interface NotificationRepository extends MongoRepository<NotificationEntity, String> {
}