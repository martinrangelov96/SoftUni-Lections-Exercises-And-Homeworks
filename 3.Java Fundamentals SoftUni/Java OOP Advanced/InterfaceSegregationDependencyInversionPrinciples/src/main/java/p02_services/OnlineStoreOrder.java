package p02_services;

import p02_services.interfaces.NotificationService;

public class OnlineStoreOrder {

    private NotificationService notificationServices[];

    public OnlineStoreOrder(NotificationService... services) {
        this.notificationServices = services;
    }

    public void process() {
        for (NotificationService notification : notificationServices) {
            if (notification.isActive()) {
                notification.sendNotification();
            }
        }
    }
}
