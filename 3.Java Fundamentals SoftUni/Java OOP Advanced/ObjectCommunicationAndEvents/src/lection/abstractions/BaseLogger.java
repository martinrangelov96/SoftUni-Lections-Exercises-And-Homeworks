package lection.abstractions;

import lection.enums.LogType;
import lection.interfaces.Handler;

public abstract class BaseLogger implements Handler {
    private Handler successor;

    protected BaseLogger() {

    }

    protected void passToSuccessor(LogType type, String message) {
        if (this.successor != null) {
            this.successor.handle(type, message);
        }
    }

    @Override
    public void setSuccessor(Handler handler) {
        this.successor = handler;
    }
}
