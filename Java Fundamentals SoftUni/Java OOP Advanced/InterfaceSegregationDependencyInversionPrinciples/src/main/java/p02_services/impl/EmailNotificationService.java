package p02_services.impl;

import p02_services.interfaces.NotificationService;

public class EmailNotificationService extends BaseNotification implements NotificationService {

    public EmailNotificationService(boolean isActive) {
        super(isActive);
    }

    public void sendNotification() {
        System.out.println("email notification");
    }
}
