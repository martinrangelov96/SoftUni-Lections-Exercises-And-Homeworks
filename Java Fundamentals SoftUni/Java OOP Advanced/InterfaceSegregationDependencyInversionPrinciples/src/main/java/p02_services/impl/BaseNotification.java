package p02_services.impl;

import p02_services.interfaces.NotificationService;

public abstract class BaseNotification implements NotificationService {

    private boolean isActive;

    public BaseNotification(boolean isActive) {
        this.isActive = isActive;
    }

    @Override
    public boolean isActive() {
        return this.isActive;
    }
}
