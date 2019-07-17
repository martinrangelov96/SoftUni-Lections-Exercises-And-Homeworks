package lection.implementations;

import lection.abstractions.BaseLogger;
import lection.enums.LogType;

public class EventLogger extends BaseLogger {

    public EventLogger() {

    }

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.EVENT) {
            System.out.println(logType.name() + ": " + message);
            return;
        }

        super.passToSuccessor(logType, message);
    }
}
