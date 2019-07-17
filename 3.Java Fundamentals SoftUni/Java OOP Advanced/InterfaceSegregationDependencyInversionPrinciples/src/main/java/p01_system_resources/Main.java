package p01_system_resources;

import p01_system_resources.impl.FileWriterImpl;
import p01_system_resources.impl.GreetingClock;
import p01_system_resources.impl.TimeProviderImpl;
import p01_system_resources.interfaces.GreetingDevice;

public class Main {
    public static void main(String[] args) {

        GreetingDevice clock = new GreetingClock(new TimeProviderImpl(), new FileWriterImpl());

        clock.greeting();

    }
}
