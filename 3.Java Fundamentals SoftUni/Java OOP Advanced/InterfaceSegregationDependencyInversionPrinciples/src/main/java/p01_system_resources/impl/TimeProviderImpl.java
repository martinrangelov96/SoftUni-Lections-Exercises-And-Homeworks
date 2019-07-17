package p01_system_resources.impl;

import p01_system_resources.interfaces.TimeProvider;

import java.time.LocalTime;

public class TimeProviderImpl implements TimeProvider {

    public TimeProviderImpl() {
    }

    @Override
    public int getCurrentHour() {
        return LocalTime.now().getHour();
    }
}
