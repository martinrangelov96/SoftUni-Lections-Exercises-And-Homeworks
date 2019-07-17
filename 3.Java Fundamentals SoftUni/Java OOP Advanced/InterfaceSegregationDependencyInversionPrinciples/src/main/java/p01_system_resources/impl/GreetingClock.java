package p01_system_resources.impl;

import p01_system_resources.interfaces.GreetingDevice;
import p01_system_resources.interfaces.TimeProvider;
import p01_system_resources.interfaces.Writer;

public class GreetingClock implements GreetingDevice {

    private TimeProvider time;
    private Writer writer;

    public GreetingClock(TimeProvider time, Writer writer) {
        this.time = time;
        this.writer = writer;
    }

    @Override
    public void greeting() {
        if (time.getCurrentHour() < 12) {
            writer.writeLine("Good morning...");
        } else if (time.getCurrentHour() < 18) {
            writer.writeLine("Good afternoon...");
        } else {
            writer.writeLine("Good evening...");
        }
    }
}
