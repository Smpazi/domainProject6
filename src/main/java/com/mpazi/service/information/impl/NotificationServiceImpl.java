package com.mpazi.service.information.impl;

import com.mpazi.domain.information.Notification;
import com.mpazi.repository.information.NotificationRepository;
import com.mpazi.repository.information.impl.NotificationRepositoryImpl;
import com.mpazi.service.information.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Map;
@Service("ServiceImpNotification")
public class NotificationServiceImpl implements NotificationService {

    @Qualifier("InMemoryNotification")
    private  static NotificationServiceImpl service = null;

    NotificationRepository repository = NotificationRepositoryImpl.getRepository();

    public static NotificationServiceImpl getInstance(){
        if(service == null)
            service =new NotificationServiceImpl();
        return service;
    }
    @Override
    public Map<String, Notification> getAll() {
        return repository.getAll();
    }

    @Override
    public Notification create(Notification notification) {
        return repository.create(notification);
    }

    @Override
    public Notification update(Notification notification) {
        return repository.update(notification);
    }

    @Override
    public void delete(String s) {
        repository.delete(s);
    }

    @Override
    public Notification read(String s) {
        return repository.read(s);
    }
}
