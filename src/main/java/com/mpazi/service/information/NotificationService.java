package com.mpazi.service.information;

import com.mpazi.domain.information.Notification;
import com.mpazi.service.IService;

import java.util.Map;

public interface NotificationService extends IService <Notification, String> {
    Map<String, Notification> getAll();
}
