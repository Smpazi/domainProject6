package com.mpazi.repository.information.impl;

import com.mpazi.domain.information.Notification;
import com.mpazi.repository.information.NotificationRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Repository("InMemoryNotification")
public class NotificationRepositoryImpl implements NotificationRepository {

    private  static NotificationRepositoryImpl repository = null;

    private  Map<String, Notification> notificationMap;

    private NotificationRepositoryImpl(){
        this.notificationMap = new HashMap<>();
    }
    public static NotificationRepositoryImpl getRepository(){
        if(repository == null)
            repository = new NotificationRepositoryImpl();
        return repository;
    }
    @Override
    public Map<String,Notification> getAll() {
        return notificationMap;
    }

    @Override
    public Notification create(Notification notification) {
        notificationMap.put(notification.getNotificationID(),notification);
        Notification savedNotif = notificationMap.get(notification.getNotificationID());
        return savedNotif;
    }

    @Override
    public Notification update(Notification notification) {
        notificationMap.put(notification.getNotificationID(),notification);
        Notification savedNotif = notificationMap.get(notification.getNotificationID());
        return savedNotif;    }

    @Override
    public Notification read(String s) {
        Notification notification = notificationMap.get(s);
        return notification;
    }

    @Override
    public void delete(String s) {
        notificationMap.remove(s);
    }
}
