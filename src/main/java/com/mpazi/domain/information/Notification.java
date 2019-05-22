package com.mpazi.domain.information;


import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
@EntityScan
public class Notification {

    private String notificationID,notificationName, notificationDate;

    private Notification(){
    }

    private Notification (Builder builder){
      this.notificationID =builder.notificationID;
      this.notificationName =builder.notificationName;
      this.notificationDate = builder.notificationDate;

    }

    public String getNotificationID() {
        return notificationID;
    }

    public String getNotificationName() {
        return notificationName;
    }

    public String getNotificationDate() {
        return notificationDate;
    }

    public static class Builder{
        private String notificationID,notificationName, notificationDate;

        public Builder notificationID(String notificationID){
            this.notificationID= notificationID;
            return this;
        }

        public Builder notificationName(String notificationName){
            this.notificationName =notificationName;
            return this;
        }

        public Builder notificationDate(String notificationDate){
            this.notificationDate =notificationDate;
            return this;
        }


        public Notification build(){
            return new Notification(this);
        }
    }

    @Override
    public String toString() {
        return "NotificationRepository {" +
                ", notificationID=' " + getNotificationID() + '\'' +
                ", notificationDate =' " + getNotificationDate() + '\'' +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Notification notification = (Notification) o;
        return getNotificationID().equals(notification.notificationID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNotificationID());
    }

}
