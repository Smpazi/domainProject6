package com.mpazi.repository.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.repository.IRepository;

import java.util.Set;

public interface NotificationRepository extends IRepository<Notification, String> {
    Set<Notification> getAll();
}
