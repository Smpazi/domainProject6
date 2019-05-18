package com.mpazi.service.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.service.IService;

import java.util.Set;

public interface NotificationService extends IService <Notification, String> {
    Set<Notification> getAll();
}
