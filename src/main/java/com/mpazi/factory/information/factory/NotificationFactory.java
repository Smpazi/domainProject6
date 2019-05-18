package com.mpazi.factory.information.factory;

import com.mpazi.domain.information.Notification;

import java.util.Map;

public class NotificationFactory {
    public static Notification getNotification(Map<String, String> values){
        return new Notification.Builder()
                .notificationID(values.get("NotificationID"))
                .notificationName(values.get("NotificationName"))
                .notificationDate(values.get("NotificationDate"))
                .build();
    }
}
