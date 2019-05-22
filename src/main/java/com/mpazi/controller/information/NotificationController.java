package com.mpazi.controller.information;

import com.mpazi.domain.information.Appointment;
import com.mpazi.domain.information.Notification;
import com.mpazi.service.information.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/notification")
public class NotificationController {
    @Autowired
    @Qualifier("ServiceImpNotification")
    private NotificationService service;

    @PostMapping("/create")
    @ResponseBody
    public Notification create(Notification notification) {
        return service.create(notification);
    }

    @PostMapping("/update")
    @ResponseBody
    public Notification update(Notification notification) {
        return service.update(notification);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        service.delete(id);

    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Notification read(@PathVariable String id) {
        return service.read(id);
    }

    @GetMapping("/read/all")
    @ResponseBody
    public Map<String, Notification> getAll() {
        return service.getAll();
    }


}
