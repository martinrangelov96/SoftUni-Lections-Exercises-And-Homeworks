package lection.implementations;

import lection.abstractions.BaseLogger;
import lection.enums.LogType;

public class CombatLogger extends BaseLogger {

    public CombatLogger() {

    }

    @Override
    public void handle(LogType logType, String message) {
        if (logType == LogType.ATTACK || logType == LogType.MAGIC) {
            System.out.println(logType.name() + ": " + message);
            return;
        }

        super.passToSuccessor(logType, message);
    }

}
