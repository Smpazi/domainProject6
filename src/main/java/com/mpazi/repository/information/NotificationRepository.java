package com.mpazi.repository.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.repository.IRepository;

import java.util.Map;
import java.util.Set;

public interface NotificationRepository extends IRepository<Notification, String> {
    Map<String,Notification> getAll();
}
