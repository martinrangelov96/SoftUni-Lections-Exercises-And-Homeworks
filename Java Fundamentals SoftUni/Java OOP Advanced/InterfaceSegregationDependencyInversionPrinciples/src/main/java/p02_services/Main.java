package p02_services;

import p02_services.impl.EmailNotificationService;
import p02_services.impl.SmsNotificationService;
import p02_services.interfaces.NotificationService;

public class Main {
    public static void main(String[] args) {

        NotificationService smsNotification = new SmsNotificationService(true);
        NotificationService emailNotification = new EmailNotificationService(false);

        OnlineStoreOrder order = new OnlineStoreOrder(smsNotification, emailNotification);

        order.process();

    }
}
