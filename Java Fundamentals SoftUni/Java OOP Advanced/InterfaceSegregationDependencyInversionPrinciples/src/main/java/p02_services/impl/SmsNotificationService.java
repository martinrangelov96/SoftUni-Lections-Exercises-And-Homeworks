package p02_services.impl;

import p02_services.interfaces.NotificationService;

public class SmsNotificationService extends BaseNotification implements NotificationService {

    public SmsNotificationService(boolean isActive) {
        super(isActive);
    }

    public void sendNotification() {
        System.out.println("sms notification");
    }
}
